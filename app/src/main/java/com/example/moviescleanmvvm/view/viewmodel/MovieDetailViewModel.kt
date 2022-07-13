package com.example.moviescleanmvvm.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.Result
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import com.example.domain.usecases.MoviesRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val useCase: MoviesRepositoryUseCase) :
    ViewModel() {

    lateinit var imdbId: String
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()


    private val _movieDetail: MutableLiveData<MovieDetail> = MutableLiveData()
    val movieDetail: LiveData<MovieDetail> = _movieDetail

    fun getMovieDetail() {
        viewModelScope.launch {
            useCase.getMovieDetail(imdbId)
        }
    }

    fun getMovieDetailDb(){
        startLoading()
        viewModelScope.launch {
            useCase.invoke(imdbId).also { stopLoading() }.onEach {
                if (!it.isNullOrEmpty())
                    _movieDetail.value=it[0]
            }.launchIn(viewModelScope)
        }
    }

    private fun stopLoading() {
        isLoading.value = false
    }

    private fun startLoading() {
        isLoading.value = true
    }

}