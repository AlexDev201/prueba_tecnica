package com.example.prueba_tecnica.domain.repository

import com.example.prueba_tecnica.domain.model.Comment
import com.example.prueba_tecnica.domain.model.Post

interface PostRepository{
    suspend fun getAllPost(): List<Post>
    suspend fun getPostById(id: Int): Post
    suspend fun getPostByTitle(title: String): List<Post>

//   suspend fun getComments(postId : Int): List<Comment>
//   suspend fun addComent(comment: Comment): Comment
}