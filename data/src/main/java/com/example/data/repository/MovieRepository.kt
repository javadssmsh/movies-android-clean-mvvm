package com.example.data.repository

import com.example.data.source.MoviesDataSource
import com.example.domain.base.Result
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import com.example.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val moviesDataSource: MoviesDataSource) :
    IMovieRepository {


    override suspend fun getBatmanMovies() {
        return moviesDataSource.getBatmanMovies()
    }

    override suspend fun insertMovie(movie: Movie) {
        return moviesDataSource.insertMovie(movie)
    }

    override suspend fun deleteMovie(movie: Movie) {
        return moviesDataSource.deleteMovie(movie)
    }

    override suspend fun getMovieDetail(imdbId: String) {
        return moviesDataSource.getMovieDetail(imdbId)
    }


    override fun getAllMovies(): Flow<List<Movie>> {
        return moviesDataSource.getAllMovies()
    }

    override fun getMovieDetailDb(imdbId: String): Flow<List<MovieDetail>> {
        return moviesDataSource.getMovieDetailDb(imdbId)
    }


}