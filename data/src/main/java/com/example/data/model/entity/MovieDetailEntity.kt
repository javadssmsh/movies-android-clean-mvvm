package com.example.data.model.entity

import androidx.room.Entity


@Entity(tableName = "movie_detail_entity", primaryKeys = ["imdbID"])
data class MovieDetailEntity(
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
)
