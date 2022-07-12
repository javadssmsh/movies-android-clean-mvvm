package com.example.moviescleanmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Movie
import com.example.moviescleanmvvm.databinding.MovieLayoutItemBinding

class MovieListAdapter(val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieListAdapter.ArticleViewHolder>() {

    enum class AdapterType { BREAKING_NEWS, FAVOURITE_NEWS }

    private var adapterArticles: MutableList<Movie> = ArrayList<Movie>()

    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }

        return ArticleViewHolder(MovieLayoutItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentRecipe = adapterArticles[position]
        holder.bind(currentRecipe, position)
    }

    override fun getItemCount(): Int {
        return adapterArticles.size
    }

    inner class ArticleViewHolder(private val binding: MovieLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie, position: Int) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    fun sendData(articles: List<Movie>) {
        val moviesDiffUtil = MoviesDiffUtil(adapterArticles, articles)
        val diffUtilResult = DiffUtil.calculateDiff(moviesDiffUtil)
        adapterArticles = articles as MutableList<Movie>
        diffUtilResult.dispatchUpdatesTo(this)
    }

}