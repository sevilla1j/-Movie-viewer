package com.jsevilla.movieviewer.data.core

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

object Constants {
    object Interceptor {
        const val TIMEOUT = 30L
    }

    object Request {
        const val CONTENT_TYPE = "Content-Type"
        const val ACCEPT = "Accept"
        const val VALUE = "application/json"
    }

    object EndPoints {
        const val KEY_CODE = "code"
        const val KEY_MESSAGE = "message"
    }

    object CodeError {
        const val ERROR401 = 401
        const val ERROR403 = 403
    }
}
