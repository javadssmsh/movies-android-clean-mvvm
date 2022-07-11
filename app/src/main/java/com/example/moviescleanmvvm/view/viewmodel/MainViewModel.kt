package com.example.moviescleanmvvm.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Movie
import com.example.domain.usecases.MoviesRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val useCase: MoviesRepositoryUseCase) : ViewModel() {

    private val _moviesList: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesList: LiveData<List<Movie>> = _moviesList

    fun getAllMovies() = useCase.invoke().onEach {
        _moviesList.value = it
    }.launchIn(viewModelScope)

    fun getBatmanMovies() {
        viewModelScope.launch {
            useCase.getBatmanMovies()
        }
    }

}