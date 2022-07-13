package com.example.data.mapper

import com.example.data.model.entity.MovieDetailEntity
import com.example.data.model.entity.MovieEntity
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail


fun MovieEntity.toDomain(): Movie {
    return Movie(
        title, year, imdbID, type, imageUrl
    )
}

fun MovieDetailEntity.toDomain(): MovieDetail {
    return MovieDetail(
        title = Title,
        year = Year,
        rated = Rated,
        released = Released,
        runtime = Runtime,
        genre = Genre,
        director = Director,
        writer = Writer, actors =  Actors,
        Language,Country,Awards,Poster,Type
    )
}