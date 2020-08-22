package com.jsevilla.movieviewer.data.network.end_points

import com.jsevilla.movieviewer.data.network.response.MovieBodyResponse
import com.jsevilla.movieviewer.data.network.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

interface EndPointsService {
    @GET("discover/movie?&sort_by=vote_count.desc&language=es-ES&include_video=true")
    suspend fun getMovies(
        @Query("api_key") api: String,
        @Query("page") page: Int
    ): Response<MovieResponse>

    @GET("movie/{id}?&language=es-ES")
    suspend fun getMovie(
        @Path("id") movieId: Int,
        @Query("api_key") api: String
    ): Response<MovieBodyResponse>
}
