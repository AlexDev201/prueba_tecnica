package com.example.prueba_tecnica.data.repository

import com.example.prueba_tecnica.data.local.dao.PostDao
import com.example.prueba_tecnica.data.remote.api.ApiService
import com.example.prueba_tecnica.data.toDomain
import com.example.prueba_tecnica.data.toEntity
import com.example.prueba_tecnica.domain.model.Post
import com.example.prueba_tecnica.domain.repository.PostRepository
import com.example.prueba_tecnica.domain.model.Comment

class PostRepositoryImpl(
    private val api: ApiService,
    private val dao: PostDao,
) : PostRepository {

    override suspend fun getAllPost(): List<Post> {
        return try {
            val remotePosts = api.getPosts()
            dao.insertAll(remotePosts.map { it.toEntity() })
            remotePosts.map { it.toDomain() }
        } catch (e: Exception) {
            dao.getAllPost().map { it.toDomain() }
        }
    }

    override suspend fun getPostById(id: Int): Post {
        val localPost = dao.getPostById(id)
        if (localPost != null) {
            return localPost.toDomain()
        }

        val remotePost = api.getPostById(id)
        dao.insert(remotePost.toEntity())
        return remotePost.toDomain()
    }

    override suspend fun getPostByTitle(title: String): List<Post> {
        return dao.getPostByTitle(title).map { it.toDomain() }
    }


}
