package com.jsevilla.movieviewer.mapper

import com.jsevilla.movieviewer.domain.entity.MovieEntity
import com.jsevilla.movieviewer.model.MovieModel

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

interface MovieModelMapper {
    suspend fun movieDomainToPresentation(movie: MovieEntity): MovieModel

    suspend fun movieListDomainToPresentation(movie: List<MovieEntity>): List<MovieModel>
}
