package com.jsevilla.movieviewer.data.repository

import com.jsevilla.movieviewer.data.network.end_points.EndPoints
import com.jsevilla.movieviewer.data.network.mapper.MovieMapper
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

class MovieRepositoryImpl(
    private val endPoints: EndPoints,
    private val mapper: MovieMapper
) : MovieRepository {
    override suspend fun getAllMovies(): Either<Failure, List<MovieEntity>> {
        return when (val response = endPoints.getMovies()) {
            is Either.Right -> Either.Right(mapper.movieListDataToDomain(response.b))
            is Either.Left -> Either.Left(response.a)
        }
    }

    override suspend fun getMovie(id: Int): Either<Failure, MovieEntity> {
        return when (val response = endPoints.getMovie(id)) {
            is Either.Right -> Either.Right(mapper.movieDataToDomain(response.b))
            is Either.Left -> Either.Left(response.a)
        }
    }
}
