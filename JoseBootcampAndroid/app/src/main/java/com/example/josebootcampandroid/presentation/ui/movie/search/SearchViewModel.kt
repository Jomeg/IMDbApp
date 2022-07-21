package com.example.josebootcampandroid.presentation.ui.movie.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.example.josebootcampandroid.domain.models.Movie
import com.example.josebootcampandroid.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {
    private var _searchMovieList = MutableLiveData<List<Movie>>()
    val searchMovieList: LiveData<List<Movie>>
        get() = _searchMovieList

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private var movieUnique = emptyList<Movie>()

    fun searchMovieByTitle(movieSearch: String) {
        if (movieSearch.isNotEmpty()) {
            _searchMovieList.value = movieUnique.filter { searchMovieList ->
                searchMovieList.title.lowercase().contains(movieSearch.lowercase())
            }
        } else {
            _searchMovieList.postValue(movieUnique)
        }
    }

    fun fromApi() {
        viewModelScope.launch {
            try {
                val response = movieUseCase(1)
                _searchMovieList.value = response
                movieUnique = response
            } catch (e: Exception) {
                _status.value = e.message
            }
        }
    }
}