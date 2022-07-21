package com.example.josebootcampandroid.data.repositories

import com.example.josebootcampandroid.data.datasource.dao.MovieDao
import com.example.josebootcampandroid.data.datasource.entities.MovieEntity
import com.example.josebootcampandroid.data.datasource.entities.MovieTopEntity
import com.example.josebootcampandroid.data.datasource.entities.toEntity
import com.example.josebootcampandroid.data.movie.models.MovieListResponse
import com.example.josebootcampandroid.data.source.RetrofitMovieDataSource
import com.example.josebootcampandroid.data.di.ApiRestManager
import com.example.josebootcampandroid.data.home.ListMovieResponse
import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.models.MovieTop
import com.example.josebootcampandroid.domain.models.toDomain
import com.example.josebootcampandroid.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: RetrofitMovieDataSource,
    private val movieDao: MovieDao
) :
    MovieRepository {
    override suspend fun getAllMoviesFromApi(listId: Int?): List<Movie> {
        val result: MovieListResponse = api.obtainMovie(1, ApiRestManager.apiKey)
        return result.moviesList.map { it.toDomain() }
    }

    override suspend fun getAllMoviesFromRoom(listId: Int?): List<Movie> {
        val result: List<MovieEntity> = movieDao.getMovies()
        return result.map { it.toDomain() }
    }

    override suspend fun getAllMoviesTopFromApi(listId: Int?): List<MovieTop> {
        val result: ListMovieResponse = api.obtainMovieList(ApiRestManager.apiKey)
        return result.homeMovieTop.map { it.toDomain() }
    }

    override suspend fun getAllMoviesTopFromRoom(listId: Int?): List<MovieTop> {
        val result: List<MovieTopEntity> = movieDao.getMoviesTop()
        return result.map { it.toDomain() }
    }

    override suspend fun insertMovies(insMovie: List<Movie>) {
        movieDao.insertMovies(insMovie.map { it.toEntity() })
    }

    override suspend fun insertMoviesTop(insMovieTop: List<MovieTop>) {
        movieDao.insertMoviesTop(insMovieTop.map { it.toEntity() })
    }
}

