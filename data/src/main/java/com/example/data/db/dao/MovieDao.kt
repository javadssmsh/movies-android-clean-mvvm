package com.example.data.db.dao

import androidx.room.*
import com.example.data.model.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_entity")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Delete
    suspend fun deleteMovie(movie: MovieEntity)

/*    @Query("SELECT EXISTS(SELECT * FROM movie_entity WHERE title = :title AND source = :source)")
    suspend fun isFavoriteNews(title: String, source: String): Boolean*/

}