package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.MovieDao
import com.example.data.db.dao.MovieDetailDao
import com.example.data.model.entity.MovieDetailEntity
import com.example.data.model.entity.MovieEntity

@Database(
    entities = [MovieEntity::class , MovieDetailEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun MovieDao(): MovieDao
    abstract fun MovieDetailDao(): MovieDetailDao

}