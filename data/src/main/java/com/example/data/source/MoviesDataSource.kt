package com.example.data.source

import android.util.Log
import com.example.data.api.MoviesApiService
import com.example.data.db.dao.MovieDao
import com.example.data.db.dao.MovieDetailDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.base.Error
import com.example.domain.base.Result
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MoviesDataSource @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val movieDao: MovieDao,
    private val movieDetailDao: MovieDetailDao
) {

    suspend fun getBatmanMovies() {
        try {
            val result = moviesApiService.getBatmanMovies(apikey = "3e974fca", name = "batman")
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

    suspend fun getMovieDetail(imdbId: String) {
        return try {
            val result = moviesApiService.getMovieDetail(apikey = "3e974fca", imdbId = imdbId)
            when {
                result.isSuccessful -> {
                    result.body().let {
                        // save to db
                        if (it != null) {
                            movieDetailDao.insertMovieDetail(it.toEntity())
                        }
                    }
                }
                else -> {}
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

    fun getMovieDetailDb(imdbId: String) : Flow<List<MovieDetail>>{
        Log.d("getMovieDetailDb", "getMovieDetailDb: ")
        return movieDetailDao.getMovieDetail(imdbId).map { list-> list.map { item-> item.toDomain() } }
    }


}