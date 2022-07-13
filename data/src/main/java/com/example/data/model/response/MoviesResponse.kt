package com.example.data.model.response

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val Search: List<MovieItem>,
    val totalResults: Int,
    val Response: Boolean,
)

data class MovieItem(
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Year")
    val year: String?,
    @SerializedName("imdbID")
    val imdbID: String?,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Poster")
    val imageUrl: String?
)

data class MovieDetailResponse(
    val Title :String,
    val Year :String,
    val Rated :String,
    val Released :String,
    val Runtime :String,
    val Genre :String,
    val Director :String,
    val Writer :String,
    val Actors :String,
    val Language :String,
    val Country :String,
    val Awards :String,
    val Poster :String,
    val Type :String,
    val imdbID :String,
    val Ratings : List<MovieRatingResponse>

)

data class MovieRatingResponse(
    val Source :String,
    val Value :String,
)


