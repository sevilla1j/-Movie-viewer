package com.jsevilla.movieviewer.data.network.mapper

import com.jsevilla.movieviewer.data.BuildConfig
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

class MovieMapperImpl : MovieMapper {
    override suspend fun movieListDataToDomain(movies: MovieResponse): List<MovieEntity> {
        return movies.results.let { list ->
            list.map { response ->
                MovieEntity(
                    id = response.id,
                    title = response.title,
                    original_title = response.original_title,
                    overview = response.overview,
                    poster_path = "${BuildConfig.BaseUrlImage}${response.poster_path}",
                    backdrop_path = "${BuildConfig.BaseUrlImage}${response.backdrop_path}",
                    release_date = response.release_date,
                    vote_count = response.vote_count
                )
            }
        }
    }

    override suspend fun movieDataToDomain(movie: MovieBodyResponse): MovieEntity {
        return MovieEntity(
            id = movie.id,
            title = movie.title,
            original_title = movie.original_title,
            overview = movie.overview,
            poster_path = "${BuildConfig.BaseUrlImage}${movie.poster_path}",
            backdrop_path = "${BuildConfig.BaseUrlImage}${movie.backdrop_path}",
            release_date = movie.release_date,
            vote_count = movie.vote_count
        )
    }
}
