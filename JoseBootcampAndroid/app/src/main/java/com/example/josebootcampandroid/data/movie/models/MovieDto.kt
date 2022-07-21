package com.example.josebootcampandroid.data.movie.models

import com.google.gson.annotations.SerializedName

data class MovieDto(
    val title: String,
    val id: Int,
    @SerializedName("backdrop_path")
    val backgroundImage: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("vote_average")
    val averageVote: Double
)