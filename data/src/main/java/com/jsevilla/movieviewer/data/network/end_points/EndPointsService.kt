package com.jsevilla.movieviewer.data.network.end_points

import retrofit2.Response
import retrofit2.http.GET

interface EndPointsService {
    @GET("todos")
    suspend fun getTodos(): Response<Unit>
}
