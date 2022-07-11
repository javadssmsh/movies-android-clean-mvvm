package com.example.moviescleanmvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.moviescleanmvvm.R
import com.example.moviescleanmvvm.view.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.getBatmanMovies()
        viewModel.getAllMovies()

        initObservers()

    }

    private fun initObservers() {
        viewModel.moviesList.observe(this) {
            for (item in it)
                Log.d("initObservers", "initObservers  :  ${item.title}")
        }
    }
}