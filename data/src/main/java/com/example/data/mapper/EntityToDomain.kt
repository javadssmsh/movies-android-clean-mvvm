package com.example.data.mapper

import com.example.data.model.entity.MovieEntity
import com.example.domain.model.Movie


fun MovieEntity.toDomain(): Movie {
    return Movie(
        title, year, imdbID, type, imageUrl
    )
}