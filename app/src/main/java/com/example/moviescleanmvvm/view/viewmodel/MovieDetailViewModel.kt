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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val useCase: MoviesRepositoryUseCase) :
    ViewModel() {

    lateinit var imdbId: String

    private val _movieDetail: MutableLiveData<MovieDetail> = MutableLiveData()
    val movieDetail: LiveData<MovieDetail> = _movieDetail

    fun getMovieDetail() {
        viewModelScope.launch {
            when (val result = useCase.getMovieDetail(imdbId)) {
                is Result.Success -> {
                    result.data.let {
                        _movieDetail.value = it
                    }
                }
                is Result.Error -> {

                }
            }
        }
    }

}