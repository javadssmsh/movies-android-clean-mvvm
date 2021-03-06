package com.example.domain.usecases

import com.example.domain.model.Movie
import com.example.domain.repository.IMovieRepository
import javax.inject.Inject

class MoviesRepositoryUseCase @Inject constructor(private val repository: IMovieRepository) {

    suspend fun getBatmanMovies() = repository.getBatmanMovies()

    suspend fun insertMovie(movie: Movie) = repository.insertMovie(movie)

    suspend fun deleteMovie(movie: Movie) = repository.deleteMovie(movie)

    operator fun invoke() = repository.getAllMovies()

    suspend fun getMovieDetail(imdbId: String) = repository.getMovieDetail(imdbId)

    operator fun invoke(imdbId: String) = repository.getMovieDetailDb(imdbId)


}