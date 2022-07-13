package com.example.data.mapper

import com.example.data.model.response.MovieDetailResponse
import com.example.data.model.response.MovieItem
import com.example.data.model.response.MovieRatingResponse
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import com.example.domain.model.MovieRating


fun MovieItem.toDomain(): Movie {
    return Movie(
        title, year, imdbID, type, imageUrl
    )
}

fun MovieDetailResponse.toDomain(): MovieDetail {
    return MovieDetail(
        title = Title,
        year = Year,
        rated = Rated,
        released = Released,
        runtime = Runtime,
        genre = Genre,
        director = Director,
        writer = Writer,
        actors = Actors,
        language = Language,
        country = Country,
        awards = Awards,
        poster = Poster,
        type = Type,
    )
}

fun MovieRatingResponse.toDomain(): MovieRating {
    return MovieRating(Source ,Value)
}