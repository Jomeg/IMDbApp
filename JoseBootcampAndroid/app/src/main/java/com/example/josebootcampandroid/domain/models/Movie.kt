package com.example.josebootcampandroid.domain.models

import com.example.josebootcampandroid.data.datasource.entities.MovieEntity
import com.example.josebootcampandroid.data.movie.models.MovieDto

data class Movie(
    val title: String,
    val id: Int,
    val backgroundImage: String,
    val date: String,
    val originalTitle: String,
    val overview: String,
    val averageVote: Double
)

fun MovieDto.toDomain() = Movie(
    title,
    id,
    backgroundImage,
    date,
    originalTitle,
    overview,
    averageVote
)

fun MovieEntity.toDomain() = Movie(
    title = title,
    id = id,
    backgroundImage = backgroundImage,
    date = date,
    originalTitle = originalTitle,
    overview = description,
    averageVote = averageVote
)