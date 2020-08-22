package com.jsevilla.movieviewer.domain.usecase

import com.jsevilla.movieviewer.domain.entity.MovieEntity
import com.jsevilla.movieviewer.domain.repository.MovieRepository

/**
 * Created by Jose Sevilla on 21/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class GetMovieUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<MovieEntity, GetMovieUseCase.Params>() {

    override suspend fun run(params: Params) = movieRepository.getMovie(params.id)

    data class Params(val id: Int)
}
