package com.jsevilla.movieviewer.data.network.end_points

import com.jsevilla.movieviewer.data.core.Constants
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class SupportInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(Constants.Request.CONTENT_TYPE, Constants.Request.VALUE)
            .addHeader(Constants.Request.ACCEPT, Constants.Request.VALUE)
            .build()
        return chain.proceed(request)
    }
}
