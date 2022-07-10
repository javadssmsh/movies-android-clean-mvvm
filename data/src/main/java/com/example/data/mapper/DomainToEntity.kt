package com.example.data.mapper

import com.example.data.model.entity.MovieEntity
import com.example.domain.model.Movie


fun Movie.toEntity():MovieEntity{
    return MovieEntity(
        title = title!!,
        year, imdbID, type, imageUrl
    )
}