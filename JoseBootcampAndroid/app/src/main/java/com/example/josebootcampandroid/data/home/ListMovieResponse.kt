package com.example.josebootcampandroid.data.home


import com.example.josebootcampandroid.data.movie.models.MovieTopDto
import com.example.josebootcampandroid.domain.models.MovieTop
import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @SerializedName("results")
    var homeMovieTop: List<MovieTopDto>
)