package com.jsevilla.movieviewer.feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsevilla.movieviewer.BR
import com.jsevilla.movieviewer.R
import com.jsevilla.movieviewer.databinding.ItemMovieBinding
import com.jsevilla.movieviewer.model.MovieModel

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MovieAdapter(
    private val movies: MutableList<MovieModel>,
    val callback: (model: MovieModel, position: Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding: ItemMovieBinding? =
            DataBindingUtil.bind(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_movie,
                        parent,
                        false
                    )
            )
        return MovieHolder(binding!!)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movieModel = movies[position]
        holder.setItem(model = movieModel)
        holder.itemMovieBinding.root.setOnClickListener {
            callback(movieModel, position)
        }
    }

    override fun getItemCount(): Int = movies.size

    fun addItems(newItems: List<MovieModel>) {
        movies.clear()
        movies.addAll(newItems)
        notifyDataSetChanged()
    }

    class MovieHolder(val itemMovieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root) {
        fun setItem(model: MovieModel) {
            itemMovieBinding.setVariable(BR.movieModel, model)
            itemMovieBinding.executePendingBindings()
        }
    }
}
