package com.example.josebootcampandroid.data.source

import com.example.josebootcampandroid.data.home.ListMovieResponse
import com.example.josebootcampandroid.data.movie.models.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitMovieDataSource {
    @GET("list/{id}")
    suspend fun obtainMovie(
        @Path("id") listId: Int?,
        @Query("api_key") apiKey: String?
    ): MovieListResponse

    @GET("movie/top_rated")
    suspend fun obtainMovieList(
        @Query("api_key") apiKey: String?
    ): ListMovieResponse
}