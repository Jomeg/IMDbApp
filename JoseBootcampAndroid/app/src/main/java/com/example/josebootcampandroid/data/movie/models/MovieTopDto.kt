package com.example.josebootcampandroid.data.movie.models

import com.google.gson.annotations.SerializedName

data class MovieTopDto(
    val id: Int,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String
)