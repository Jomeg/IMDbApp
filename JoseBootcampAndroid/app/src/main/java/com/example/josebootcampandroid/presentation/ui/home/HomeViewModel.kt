package com.example.josebootcampandroid.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.josebootcampandroid.domain.models.MovieTop
import com.example.josebootcampandroid.domain.usecase.MovieHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieHomeUseCase: MovieHomeUseCase) :
    ViewModel() {
    private val _homeMovie = MutableLiveData<List<MovieTop>>()
    val homeMovie: LiveData<List<MovieTop>>
        get() = _homeMovie

    fun fromApi() {
        viewModelScope.launch {
            try {
                val response = movieHomeUseCase()
                _homeMovie.value = response
            } catch (e: Exception) {
                Log.i("R", "Error presentado")
            }
        }
    }
}