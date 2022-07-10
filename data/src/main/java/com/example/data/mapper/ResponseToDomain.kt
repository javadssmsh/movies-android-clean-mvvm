package com.example.data.mapper

import com.example.data.model.response.MovieItem
import com.example.domain.model.Movie


fun MovieItem.toDomain(): Movie {
    return Movie(
        title, year, imdbID, type, imageUrl
    )
}