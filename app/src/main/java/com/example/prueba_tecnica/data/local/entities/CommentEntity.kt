package com.example.prueba_tecnica.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class Comment(
    @PrimaryKey val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)