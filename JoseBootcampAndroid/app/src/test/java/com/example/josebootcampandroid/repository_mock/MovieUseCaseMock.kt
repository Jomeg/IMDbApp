package com.example.josebootcampandroid.repository_mock

import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.models.MovieTop
import com.example.josebootcampandroid.domain.repositories.MovieRepository

class MovieUseCaseMock : MovieRepository {

    override suspend fun getAllMoviesFromApi(listId: Int?): List<Movie> {

        lateinit var movieListResponse: List<Movie>

        when (listId) {
            1 -> {
                var listala = listOf<Movie>(
                    Movie(
                        "Transformer 1",
                        1,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "2022",
                        "Transformer 1",
                        "N/A",
                        8.2
                    ),
                    Movie("La venganza de los caídos", 2, "", "2009", "", "", 5.1),
                    Movie("El lado oscuro de la luna", 3, "", "2010", "", "", 6.3)
                )
                movieListResponse = listala
            }
            2 -> {
                movieListResponse = emptyList()
            }
        }
        return movieListResponse
    }

    override suspend fun getAllMoviesFromRoom(listId: Int?): List<Movie> {
        lateinit var movieListResponse: List<Movie>
        when (listId) {
            1 -> {
                var lista2 = listOf<Movie>(
                    Movie(
                        "La venganza de los caidos",
                        1,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "2008",
                        "La venganza de los caidos",
                        "N/A",
                        6.12
                    ),
                    Movie("El lado oscuro de la luna", 2, "", "2010", "", "", 6.3),
                    Movie(
                        "Transformer 1",
                        1,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "2022",
                        "Transformer 1",
                        "N/A",
                        8.2
                    )
                )
                movieListResponse = lista2
            }
            2 -> {
                movieListResponse = emptyList()
            }
        }
        return movieListResponse
    }

    override suspend fun getAllMoviesTopFromApi(listId: Int?): List<MovieTop> {
        lateinit var movieListResponse: List<MovieTop>
        when (listId) {
            1 -> {
                var lista3 = listOf<MovieTop>(
                    MovieTop(
                        1,
                        "Spider Man",
                        4.5,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e"
                    ),
                    MovieTop(
                        2,
                        "Iron Man",
                        6.3,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e"
                    ),
                    MovieTop(
                        3,
                        "Batman",
                        5.2,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e"
                    )
                )
                movieListResponse = lista3
            }
            2 -> {
                movieListResponse = emptyList()
            }
        }
        return movieListResponse
    }

    override suspend fun getAllMoviesTopFromRoom(listId: Int?): List<MovieTop> {
        lateinit var movieListResponse: List<MovieTop>
        when (listId) {
            1 -> {
                var list4 = listOf<MovieTop>(
                    MovieTop(
                        1,
                        "Aquaman",
                        4.5,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e"
                    ),
                    MovieTop(
                        2,
                        "Thor",
                        6.3,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e"
                    ),
                    MovieTop(
                        3,
                        "X-Men",
                        5.2,
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e",
                        "https://static.wikia.nocookie.net/arrow/images/d/dc/Season_2_first_promo.png/revision/latest?cb=20141012195936&path-prefix=e"
                    )
                )
                movieListResponse = list4
            }
            2 -> {
                movieListResponse = emptyList()
            }
        }
        return movieListResponse
    }

    override suspend fun insertMovies(insMovie: List<Movie>) {
        TODO("Not yet implemented")
    }

    override suspend fun insertMoviesTop(insMovieTop: List<MovieTop>) {
        TODO("Not yet implemented")
    }
}