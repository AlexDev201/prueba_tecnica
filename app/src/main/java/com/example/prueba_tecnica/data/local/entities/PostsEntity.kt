package com.example.prueba_tecnica.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Posts(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "userId")
    val userId: Int,
    @ColumnInfo(name = "title" )
    val title: String,
    @ColumnInfo(name = "body" )
    val body : String
)