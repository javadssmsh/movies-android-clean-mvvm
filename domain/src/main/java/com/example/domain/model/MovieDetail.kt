package com.example.domain.model

data class MovieDetail(
    val title :String,
    val year :String,
    val rated :String,
    val released :String,
    val runtime :String,
    val genre :String,
    val director :String,
    val writer :String,
    val actors :String,
    val language :String,
    val country :String,
    val awards :String,
    val poster :String,
    val type :String,

)

data class MovieRating(
    val source :String,
    val value :String,
)
