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

    object Preferences {
        const val SECURE_PREFS_FILE_KEY = "com.jsevilla.movieviewer.secure_preferences"
        const val PREF_KEY_ACCESS_TOKEN = "key_user_access_token"
    }
}
