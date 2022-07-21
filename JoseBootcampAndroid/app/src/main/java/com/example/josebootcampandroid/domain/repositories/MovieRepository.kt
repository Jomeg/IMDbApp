package com.example.josebootcampandroid.domain.repositories

import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.models.MovieTop

interface MovieRepository {
    suspend fun getAllMoviesFromApi(listId: Int?): List<Movie>
    suspend fun getAllMoviesFromRoom(listId: Int?): List<Movie>
    suspend fun getAllMoviesTopFromApi(listId: Int?): List<MovieTop>
    suspend fun getAllMoviesTopFromRoom(listId: Int?): List<MovieTop>
    suspend fun insertMovies(insMovie: List<Movie>)
    suspend fun insertMoviesTop(insMovieTop: List<MovieTop>)
}

