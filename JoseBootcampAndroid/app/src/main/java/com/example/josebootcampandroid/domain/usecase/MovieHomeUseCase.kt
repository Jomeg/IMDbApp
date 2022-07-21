package com.example.josebootcampandroid.domain.usecase

import com.example.josebootcampandroid.domain.models.MovieTop
import com.example.josebootcampandroid.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieHomeUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<MovieTop> {
        var movieResponse = movieRepository.getAllMoviesTopFromRoom(1)
        if (movieResponse.isEmpty()) {
            movieResponse = movieRepository.getAllMoviesTopFromApi(1)
            movieRepository.insertMoviesTop(movieResponse)
            return movieResponse
        } else {
            return movieResponse
        }
    }
}