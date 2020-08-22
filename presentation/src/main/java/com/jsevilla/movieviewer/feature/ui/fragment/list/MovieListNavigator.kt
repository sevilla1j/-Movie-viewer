package com.jsevilla.movieviewer.feature.ui.fragment.list

import com.jsevilla.movieviewer.model.MovieModel

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

interface MovieListNavigator {
    fun onMovieObjectClick(movie: MovieModel)
}
