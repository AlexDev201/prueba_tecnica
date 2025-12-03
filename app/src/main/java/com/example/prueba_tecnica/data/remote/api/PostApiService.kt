package com.example.prueba_tecnica.data.remote.api

import com.example.prueba_tecnica.data.remote.dto.PostDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService{
    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id : Int): PostDto

//    @GET("posts/{postId}/comments")
//    suspend fun getComments(@Path("postId") postId: Int): List<Comment>
//
//    @POST("comments")
//    suspend fun addComment(@Body comment: CommentDto): CommentDto

}

val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()