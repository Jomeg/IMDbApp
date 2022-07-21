package com.example.josebootcampandroid.data.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.josebootcampandroid.domain.models.Movie

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "background_image") val backgroundImage: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "original_title") val originalTitle: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "average_vote") val averageVote: Double
)

fun Movie.toEntity() = MovieEntity(
    id = id,
    title = title,
    backgroundImage = backgroundImage,
    date = date,
    originalTitle = originalTitle,
    description = overview,
    averageVote = averageVote
)
