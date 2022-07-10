package com.example.data.source

import com.example.data.api.MoviesApiService
import com.example.data.db.dao.MovieDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.base.Error
import com.example.domain.base.Result
import com.example.domain.model.Movie
import javax.inject.Inject

class MoviesDataSource @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val movieDao: MovieDao
) {

    suspend fun getBatmanMovies(): Result<List<Movie>> {
        val result = moviesApiService.getBatmanMovies()
        return when {
            result.isSuccessful -> {
                result.body().let {
                    Result.Success(it?.Search!!.map { movieItem ->  movieItem.toDomain()})
                }
            }
            else -> Result.Error(Error.Internet)
        }
    }

    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie.toEntity())
    }

    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie.toEntity())
    }

    suspend fun getAllMovies() : List<Movie>{
        return movieDao.getAllMovies().map { item->item.toDomain() }
    }


}