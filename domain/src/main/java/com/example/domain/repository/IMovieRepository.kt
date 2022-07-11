package com.example.domain.repository

import com.example.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    suspend fun getBatmanMovies()

    suspend fun insertMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)

     fun getAllMovies() : Flow<List<Movie>>


}