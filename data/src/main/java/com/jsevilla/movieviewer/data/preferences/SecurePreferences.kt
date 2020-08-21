package com.jsevilla.movieviewer.data.preferences

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

interface SecurePreferences {
    fun saveLogInInfo(token: String)
    fun getAccessToken(): String
    fun logOut()
}
