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
