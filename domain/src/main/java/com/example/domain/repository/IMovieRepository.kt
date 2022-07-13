package com.example.domain.repository

import com.example.domain.base.Result
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    suspend fun getBatmanMovies()

    suspend fun insertMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)

    suspend fun getMovieDetail(imdbId: String)

     fun getAllMovies() : Flow<List<Movie>>

     fun getMovieDetailDb(imdbId: String) : Flow<List<MovieDetail>>

}