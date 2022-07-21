package com.example.josebootcampandroid.domain.models

import com.example.josebootcampandroid.data.datasource.entities.MovieTopEntity
import com.example.josebootcampandroid.data.movie.models.MovieTopDto

data class MovieTop(
    val id: Int,
    val title: String,
    val voteAverage: Double,
    val posterPath: String,
    val backdropPath: String
)

fun MovieTopDto.toDomain() = MovieTop(
    id,
    title,
    voteAverage,
    posterPath,
    backdropPath
)

fun MovieTopEntity.toDomain() = MovieTop(
    id = id,
    title = title,
    voteAverage = voteAverage,
    posterPath = posterPath,
    backdropPath = backdropPath
)