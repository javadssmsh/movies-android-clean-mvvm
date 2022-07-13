package com.example.moviescleanmvvm.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviescleanmvvm.R
import com.example.moviescleanmvvm.view.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private val viewModel: MovieDetailViewModel by viewModels()

    lateinit var movieImage: ImageView
    lateinit var tvTitle: TextView
    lateinit var tvYear: TextView
    lateinit var tvPublishedAt: TextView
    lateinit var tvLanguage: TextView
    lateinit var tvActors: TextView
    lateinit var tvPlot: TextView
    lateinit var progressBar: ProgressBar

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
        viewModel.getMovieDetailDb()
    }

    private fun initObservers() {
        viewModel.movieDetail.observe(this) {
            tvTitle.text = it.title
            tvYear.text = it.year
            tvPublishedAt.text = it.rated
            tvLanguage.text = it.language
            tvActors.text = it.actors
            tvPlot.text=it.type
            loadImage(it.poster,movieImage)
        }

        viewModel.isLoading.observe(this) {
            progressBar.visibility = when (it) {
                true -> View.VISIBLE
                false -> View.INVISIBLE
            }

        }
    }

    private fun initViews() {
        movieImage = findViewById(R.id.ivMovieImage)
        tvTitle = findViewById(R.id.tvTitle)
        tvYear = findViewById(R.id.tvYear)
        tvPublishedAt = findViewById(R.id.tvPublishedAt)
        progressBar = findViewById(R.id.progressBar)
        tvLanguage = findViewById(R.id.tvLanguage)
        tvActors = findViewById(R.id.tvActors)
        tvPlot = findViewById(R.id.tvPlot)
    }

    private fun handleIntent() {
        intent.extras?.apply {
            if (containsKey(EXTRA_VIDEO))
                viewModel.imdbId = this.getString(EXTRA_VIDEO)!!
        }
    }

    fun loadImage(url :String , view: ImageView){
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(com.example.moviescleanmvvm.R.drawable.ic_image_placeholder)
            .error(com.example.moviescleanmvvm.R.drawable.ic_error)




        Glide.with(this).load(url).apply(options).into(view)
    }

}