package com.jsevilla.movieviewer.data.network.response

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

data class MovieBodyResponse(
    val id: Long? = null,
    val title: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val backdrop_path: String? = null,
    val release_date: String? = null,
    val vote_count: Long? = null
)
