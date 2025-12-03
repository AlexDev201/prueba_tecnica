package com.example.prueba_tecnica.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.prueba_tecnica.data.local.entities.Posts
import com.example.prueba_tecnica.data.local.entities.PostWithComments

@Dao
interface PostDao{

    @Query("SELECT * FROM posts")
    suspend fun getAllPost(): List<Posts>
    @Query("SELECT * FROM posts WHERE id = :id")
    suspend fun getPostById(id: Int): Posts?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAll(posts: List<Posts>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post:Posts)

    @Query("SELECT * FROM posts WHERE title LIKE '%' || :title || '%'")
    suspend fun getPostByTitle(title: String): List<Posts>

    @Transaction
    @Query("SELECT * FROM posts WHERE id = :id")
    suspend fun getPostWithComments(id: Int): PostWithComments
}