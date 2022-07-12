package com.example.moviescleanmvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescleanmvvm.R
import com.example.moviescleanmvvm.view.adapter.MovieListAdapter
import com.example.moviescleanmvvm.view.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var moviesList: RecyclerView

    private val moviesAdapter by lazy {
        MovieListAdapter(onClick = {})
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
        viewModel.getBatmanMovies()
        viewModel.getAllMovies()

        initObservers()

    }

    private fun initViews() {
        moviesList = findViewById(R.id.moviesList)
        moviesList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = moviesAdapter
        }

    }

    private fun initObservers() {
        viewModel.moviesList.observe(this) {
            moviesAdapter.sendData(it)

            for (item in it)
                Log.d("initObservers", "initObservers  :  ${item.title}")
        }
    }
}