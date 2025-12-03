package com.example.prueba_tecnica.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class PostWithComments(
    @Embedded val post: Posts,
    @Relation(
        parentColumn = "id",
        entityColumn = "postId"
    )
    val comments: List<Comment>
)