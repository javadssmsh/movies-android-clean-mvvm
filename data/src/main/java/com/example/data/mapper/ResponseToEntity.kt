package com.example.data.mapper

import com.example.data.model.entity.MovieDetailEntity
import com.example.data.model.entity.MovieEntity
import com.example.data.model.response.MovieDetailResponse
import com.example.data.model.response.MovieItem


fun MovieItem.toEntity(): MovieEntity {
    return MovieEntity(
        title!!, year, imdbID, type, imageUrl!!
    )
}

fun MovieDetailResponse.toEntity(): MovieDetailEntity {
    return MovieDetailEntity(
        Title,
        Year,
        Rated,
        Released,
        Runtime,
        Genre,
        Director,
        Writer,
        Actors,
        Language,
        Country,
        Awards,
        Poster,
        Type,
        imdbID
    )
}