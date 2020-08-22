package com.jsevilla.movieviewer.data.network.response

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

data class MovieResponse(
    val page: Int,
    val results: List<MovieBodyResponse>,
    val total_pages: Long,
    val total_results: Long
)
