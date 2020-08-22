package com.jsevilla.movieviewer.domain.usecase

import com.jsevilla.movieviewer.domain.entity.Either
import com.jsevilla.movieviewer.domain.entity.Failure
import com.jsevilla.movieviewer.domain.entity.MovieEntity
import com.jsevilla.movieviewer.domain.repository.MovieRepository

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class GetMovieListUseCase(private val movieRepository: MovieRepository) :
    BaseUseCase<List<MovieEntity>, Any>() {

    override suspend fun run(params: Any): Either<Failure, List<MovieEntity>> =
        movieRepository.getAllMovies()
}
