package com.example.data.model.entity

import androidx.room.Entity

@Entity(tableName = "movie_entity", primaryKeys = ["title", "imageUrl"])
data class MovieEntity(
    val title: String?,
    val year: String?,
    val imdbID: String?,
    val type: String?,
    val imageUrl: String?
)