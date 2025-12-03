package com.example.prueba_tecnica.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prueba_tecnica.data.local.entities.Comment

@Dao
interface CommentDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(comments: List<Comment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: Comment)

    @Query("SELECT * FROM comments WHERE postId = :postId")
    suspend fun getCommentsByPostId(postId: Int): List<Comment>
}
