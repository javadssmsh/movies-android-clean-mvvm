package com.example.domain.repository

import com.example.domain.base.Result
import com.example.domain.model.Movie

interface IMovieRepository {

    suspend fun getBatmanMovies(): Result<List<Movie>>

    suspend fun insertMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)

    suspend fun getAllMovies() : List<Movie>


}