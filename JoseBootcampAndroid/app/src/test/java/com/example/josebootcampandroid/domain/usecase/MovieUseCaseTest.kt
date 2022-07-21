package com.example.josebootcampandroid.domain.usecase

import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.models.MovieTop
import com.example.josebootcampandroid.repository_mock.MovieUseCaseMock
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class MovieUseCaseTest{
    @Test
    fun returnEmptyMovieFromApi() = runBlocking {

        //Arrange
        var parameter = 1
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
        val date = "2009"

        //Action
        val result = MovieUseCaseMock().getAllMoviesFromApi(1)

        //Assert
        assertEquals(result, listala)
    }

    @Test
    fun returnEmptyMovieFromRoom() = runBlocking {

        //Arrange
        var paramter = 1
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
        val date = "2010"

        //Action
        val result = MovieUseCaseMock().getAllMoviesFromRoom(1)

        //Assert
        assertEquals(result, lista2)
    }

    @Test
    fun returnEmptyMovieTopFromApi() = runBlocking {
        //Arrrange
        var parameter = 1
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
        val voteAverage = 6.3

        //Action
        val result = MovieUseCaseMock().getAllMoviesTopFromApi(1)

        //Assert
        assertEquals(result, lista3)
    }

    @Test
    fun returnEmptyMovieTopFromRoom() = runBlocking {
        //Arrage
        var parameter = 1
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
        val title = "Thor"

        //Action
        val result = MovieUseCaseMock().getAllMoviesTopFromRoom(1)

        //Assert
        assertEquals(result, list4)
    }
}