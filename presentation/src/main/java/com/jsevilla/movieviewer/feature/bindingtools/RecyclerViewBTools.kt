package com.jsevilla.movieviewer.feature.bindingtools

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsevilla.movieviewer.feature.adapter.MovieAdapter

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

@BindingAdapter("movieAdapter")
fun setMovieAdapter(recyclerView: RecyclerView, adapter: MovieAdapter) {
    recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 2)
    recyclerView.adapter = adapter
}
