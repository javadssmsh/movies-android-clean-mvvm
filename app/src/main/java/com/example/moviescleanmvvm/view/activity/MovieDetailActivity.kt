package com.example.moviescleanmvvm.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.example.moviescleanmvvm.R
import com.example.moviescleanmvvm.view.viewmodel.MainViewModel
import com.example.moviescleanmvvm.view.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private val viewModel: MovieDetailViewModel by viewModels()

    lateinit var movieImage: ImageView
    lateinit var tvTitle: TextView
    lateinit var tvYear: TextView
    lateinit var tvPublishedAt: TextView

    companion object {

        private const val EXTRA_VIDEO = "video_extra"

        fun showActivity(context: Context, imdbId: String) {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_VIDEO, imdbId)
            context.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        handleIntent()
        initViews()
        initObservers()
        viewModel.getMovieDetail()
    }

    private fun initObservers() {
        viewModel.movieDetail.observe(this) {
            tvTitle.text = it.title
            tvYear.text = it.year
            tvPublishedAt.text = it.rated
        }
    }

    private fun initViews() {
        movieImage = findViewById(R.id.ivMovieImage)
        tvTitle = findViewById(R.id.tvTitle)
        tvYear = findViewById(R.id.tvYear)
        tvPublishedAt = findViewById(R.id.tvPublishedAt)
    }

    private fun handleIntent() {
        intent.extras?.apply {
            if (containsKey(EXTRA_VIDEO))
                viewModel.imdbId = this.getString(EXTRA_VIDEO)!!
        }
    }
}