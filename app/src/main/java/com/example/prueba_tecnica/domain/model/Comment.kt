package com.example.prueba_tecnica.domain.model

import java.time.LocalDateTime

data class Comment(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val Body: String
)