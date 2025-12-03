package com.example.prueba_tecnica.domain.usecase

import androidx.room.Query
import com.example.prueba_tecnica.domain.model.Post
import com.example.prueba_tecnica.domain.repository.PostRepository

class SearchPostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(title: String): List<Post> {
        if (title.isBlank()) {
            return emptyList()
        }
        return repository.getPostByTitle(title)
    }
}
