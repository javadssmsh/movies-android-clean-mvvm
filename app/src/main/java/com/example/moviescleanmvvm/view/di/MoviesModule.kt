package com.example.moviescleanmvvm.view.di

import com.example.data.api.MoviesApiService
import com.example.data.db.dao.MovieDao
import com.example.data.repository.MovieRepository
import com.example.data.source.MoviesDataSource
import com.example.domain.repository.IMovieRepository
import com.example.domain.usecases.MoviesRepositoryUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsBindingModule {

    @Binds
    abstract fun bindMoviesRepository(movieRepository: MovieRepository): IMovieRepository

}

@Module
@InstallIn(ActivityComponent::class)
class NewsModule {

    @Provides
    fun provideMoviesRepositoryUseCase(movieRepository: MovieRepository) =
        MoviesRepositoryUseCase(movieRepository)


    @Provides
    fun provideMovieDataSource(
        moviesApiService: MoviesApiService,
        movieDao: MovieDao
    ) = MoviesDataSource(moviesApiService, movieDao)
}