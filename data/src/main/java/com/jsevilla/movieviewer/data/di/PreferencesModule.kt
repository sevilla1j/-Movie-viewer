package com.jsevilla.movieviewer.data.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.jsevilla.movieviewer.data.core.Constants
import com.jsevilla.movieviewer.data.preferences.SecurePreferences
import com.jsevilla.movieviewer.data.preferences.SecurePreferencesImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

val preferencesModule = module {
    single(named("securePrefs")) { provideSecurePreferences(androidApplication()) }
    single<SecurePreferences> { SecurePreferencesImpl(get(named("securePrefs"))) }
}

private fun provideSecurePreferences(app: Application): SharedPreferences =
    app.getSharedPreferences(Constants.Preferences.SECURE_PREFS_FILE_KEY, Context.MODE_PRIVATE)
