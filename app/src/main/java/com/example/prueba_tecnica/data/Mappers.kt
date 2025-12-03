package com.example.prueba_tecnica.data


import com.example.prueba_tecnica.data.local.entities.Posts
import com.example.prueba_tecnica.data.remote.dto.CommentDto
import com.example.prueba_tecnica.data.remote.dto.PostDto
import com.example.prueba_tecnica.data.local.entities.Comment
import com.example.prueba_tecnica.domain.model.Post

// Post Mappers
fun PostDto.toDomain(): Post {
    return Post(
        id = this.id,
        userId = this.userId,
        title = this.title,
        body = this.body
    )
}

fun Posts.toDomain(): Post {
    return Post(
        id = this.id,
        userId = this.userId,
        title = this.title,
        body = this.body
    )
}

fun PostDto.toEntity(): Posts {
    return Posts(
        id = this.id,
        userId = this.userId,
        title = this.title,
        body = this.body
    )
}

//Comments DTO

fun CommentDto.toDomain(): Comment {
    return Comment(
        id= this.id,
        postId = this.postId,
        name = this.name,
        email = this.email,
        body = this.body
    )
}

fun Comment.toDomain(): Comment {
    return Comment(
        id= this.id,
        postId = this.postId,
        name = this.name,
        email = this.email,
        body = this.body
    )
}

fun CommentDto.toEntity(): Comment {
    return Comment(
        id= this.id,
        postId = this.postId,
        name = this.name,
        email = this.email,
        body = this.body
    )
}

