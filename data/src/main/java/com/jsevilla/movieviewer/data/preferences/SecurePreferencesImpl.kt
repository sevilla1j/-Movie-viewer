package com.jsevilla.movieviewer.data.preferences

import android.content.SharedPreferences
import com.jsevilla.movieviewer.data.core.Constants

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class SecurePreferencesImpl(private val prefs: SharedPreferences) : SecurePreferences {
    override fun saveLogInInfo(token: String) {
        prefs.edit().putString(Constants.Preferences.PREF_KEY_ACCESS_TOKEN, "Bearer $token").apply()
    }

    override fun getAccessToken() =
        prefs.getString(Constants.Preferences.PREF_KEY_ACCESS_TOKEN, "") ?: ""

    override fun logOut() = prefs.edit().clear().apply()
}
