package com.example.data.db.dao

import androidx.room.*
import com.example.data.model.entity.MovieDetailEntity
import com.example.data.model.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDetailDao {

    @Query("SELECT * FROM movie_detail_entity WHERE imdbID =:imdbId")
    fun getMovieDetail(imdbId: String): Flow<List<MovieDetailEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movieDetail: MovieDetailEntity)

    @Delete
    suspend fun deleteMovie(movieDetail: MovieDetailEntity)


}