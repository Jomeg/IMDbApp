package com.example.josebootcampandroid.data.movie.models

import com.example.josebootcampandroid.data.datasource.dao.MovieDao
import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.models.MovieTop
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("items")
    var moviesList: List<MovieDto>
)