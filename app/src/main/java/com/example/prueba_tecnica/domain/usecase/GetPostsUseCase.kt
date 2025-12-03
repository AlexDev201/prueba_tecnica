package com.example.prueba_tecnica.domain.usecase

import com.example.prueba_tecnica.domain.model.Post
import com.example.prueba_tecnica.domain.repository.PostRepository

class getPostUseCase(
    private val repository: PostRepository
){
    suspend operator fun invoke(): List<Post>{
        return  repository.getAllPost()
    }
}