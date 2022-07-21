package com.example.josebootcampandroid.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.josebootcampandroid.data.datasource.dao.MovieDao
import com.example.josebootcampandroid.data.datasource.entities.MovieEntity
import com.example.josebootcampandroid.data.datasource.entities.MovieTopEntity

@Database(entities = [MovieEntity::class, MovieTopEntity::class], version = 1)
abstract class MovieDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}