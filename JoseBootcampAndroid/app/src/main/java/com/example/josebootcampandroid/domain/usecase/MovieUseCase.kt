package com.example.josebootcampandroid.domain.usecase

import android.security.identity.AccessControlProfileId
import com.example.josebootcampandroid.data.movie.models.MovieListResponse
import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    //suspend operator fun invoke() = movieRepository.getAllMovies(1)
    suspend operator fun invoke(listId: Int): List<Movie> {
        var movieResponse = movieRepository.getAllMoviesFromRoom(1)
        if (movieResponse.isEmpty()) {
            movieResponse = movieRepository.getAllMoviesFromApi(1)
            movieRepository.insertMovies(movieResponse)
            return movieResponse
        }else {
            return movieResponse
        }
    }
}