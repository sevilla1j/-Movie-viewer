package com.jsevilla.movieviewer.data.network.mapper

import com.jsevilla.movieviewer.data.network.response.MovieBodyResponse
import com.jsevilla.movieviewer.data.network.response.MovieResponse
import com.jsevilla.movieviewer.domain.entity.MovieEntity

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

interface MovieMapper {
    suspend fun movieListDataToDomain(movies: MovieResponse): List<MovieEntity>

    suspend fun movieDataToDomain(movie: MovieBodyResponse): MovieEntity
}
