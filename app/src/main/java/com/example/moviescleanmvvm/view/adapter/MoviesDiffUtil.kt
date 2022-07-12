package com.example.moviescleanmvvm.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Movie

class MoviesDiffUtil (private val oldList: List<Movie>, private val newList: List<Movie>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}