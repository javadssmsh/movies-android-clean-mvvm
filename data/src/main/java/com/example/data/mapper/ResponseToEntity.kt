package com.example.data.mapper

import com.example.data.model.entity.MovieEntity
import com.example.data.model.response.MovieItem


fun MovieItem.toEntity(): MovieEntity {
    return MovieEntity(
        title!!, year, imdbID, type, imageUrl!!
    )
}