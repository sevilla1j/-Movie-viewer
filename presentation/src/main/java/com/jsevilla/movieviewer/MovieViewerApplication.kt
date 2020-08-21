package com.jsevilla.movieviewer

import android.app.Application
import com.jsevilla.movieviewer.data.di.mapperDataModule
import com.jsevilla.movieviewer.data.di.networkModule
import com.jsevilla.movieviewer.data.di.preferencesModule
import com.jsevilla.movieviewer.data.di.repositoryModule
import com.jsevilla.movieviewer.domain.di.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MovieViewerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieViewerApplication)
            modules(
                arrayListOf(
                    networkModule,
                    preferencesModule,
                    mapperDataModule,
                    repositoryModule,
                    useCasesModule
                )
            )
        }
    }
}
