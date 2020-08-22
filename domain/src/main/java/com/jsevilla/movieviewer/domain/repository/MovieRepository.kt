package com.jsevilla.movieviewer.domain.repository

import com.jsevilla.movieviewer.domain.entity.Either
import com.jsevilla.movieviewer.domain.entity.Failure
import com.jsevilla.movieviewer.domain.entity.MovieEntity

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

interface MovieRepository {
    suspend fun getAllMovies(): Either<Failure, List<MovieEntity>>

    suspend fun getMovie(id: Int): Either<Failure, MovieEntity>
}
