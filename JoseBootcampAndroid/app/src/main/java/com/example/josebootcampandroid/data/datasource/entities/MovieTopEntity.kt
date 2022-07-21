package com.example.josebootcampandroid.data.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.josebootcampandroid.domain.models.MovieTop

@Entity(tableName = "movie_top_table")
data class MovieTopEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "vote_average") val voteAverage: Double,
    @ColumnInfo(name = "poster_path") val posterPath: String,
    @ColumnInfo(name = "backdrop_path") val backdropPath: String
)

fun MovieTop.toEntity() = MovieTopEntity(
    id = id,
    title = title,
    voteAverage = voteAverage,
    posterPath = posterPath,
    backdropPath = backdropPath
)