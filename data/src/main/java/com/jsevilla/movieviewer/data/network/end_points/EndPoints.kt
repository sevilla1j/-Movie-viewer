package com.jsevilla.movieviewer.data.network.end_points

import com.jsevilla.movieviewer.data.network.response.MovieBodyResponse
import com.jsevilla.movieviewer.data.network.response.MovieResponse
import com.jsevilla.movieviewer.domain.entity.Either
import com.jsevilla.movieviewer.domain.entity.Failure

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

interface EndPoints {
    suspend fun getMovies(): Either<Failure, MovieResponse>

    suspend fun getMovie(movieId: Int): Either<Failure, MovieBodyResponse>
}
