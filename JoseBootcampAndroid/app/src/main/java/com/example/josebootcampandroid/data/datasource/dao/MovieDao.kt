package com.example.josebootcampandroid.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.josebootcampandroid.data.datasource.entities.MovieEntity
import com.example.josebootcampandroid.data.datasource.entities.MovieTopEntity

@Dao
interface MovieDao {
    @Query("select * from movie_table")
    suspend fun getMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(insMovie: List<MovieEntity>)

    @Query("select * from movie_top_table")
    suspend fun getMoviesTop(): List<MovieTopEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesTop(insMovieTop: List<MovieTopEntity>)
}

