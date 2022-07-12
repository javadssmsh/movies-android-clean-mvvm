package com.example.data.source

import com.example.data.api.MoviesApiService
import com.example.data.db.dao.MovieDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.base.Error
import com.example.domain.base.Result
import com.example.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MoviesDataSource @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val movieDao: MovieDao
) {

    suspend fun getBatmanMovies() {
        try {
            val result = moviesApiService.getBatmanMovies(apikey = "3e974fca" , name = "batman")
            when {
                result.isSuccessful -> {
                    result.body().let {
                        //save to db
                        it?.Search?.map { movieItem -> movieDao.insertMovie(movieItem.toEntity()) }
                    }
                }
                else -> Result.Error(Error.Internet)
            }
        } catch (e: Exception) {
        }
    }

    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie.toEntity())
    }

    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie.toEntity())
    }

    fun getAllMovies(): Flow<List<Movie>> {
        return movieDao.getAllMovies().map { list -> list.map { item -> item.toDomain() } }
    }


}