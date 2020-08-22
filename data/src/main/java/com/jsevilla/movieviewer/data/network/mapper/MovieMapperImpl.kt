package com.jsevilla.movieviewer.data.network.mapper

import com.jsevilla.movieviewer.data.BuildConfig
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
                    backdrop_path = response.backdrop_path,
                    release_date = response.release_date,
                    vote_count = response.vote_count
                )
            }
        }
    }

    override suspend fun movieDataToDomain(todo: MovieResponse): MovieEntity {
        return MovieEntity(
            id = 1
        )
    }
}
