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

class MovieModelMapperImpl : MovieModelMapper {
    override suspend fun movieListDomainToPresentation(movie: List<MovieEntity>): List<MovieModel> {
        return movie.map { movieEntity ->
            MovieModel(
                id = movieEntity.id,
                original_title = movieEntity.original_title,
                poster_path = movieEntity.poster_path,
                release_date = movieEntity.release_date,
                vote_count = movieEntity.vote_count
            )
        }
    }

    override suspend fun movieDomainToPresentation(movie: MovieEntity): MovieModel {
        return MovieModel(
            id = movie.id,
            original_title = movie.original_title,
            poster_path = movie.poster_path,
            release_date = movie.release_date,
            vote_count = movie.vote_count,
            overview = movie.overview
        )
    }
}
