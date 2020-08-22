package com.jsevilla.movieviewer.data.di

import com.jsevilla.movieviewer.data.BuildConfig
import com.jsevilla.movieviewer.data.core.ConnectionUtils
import com.jsevilla.movieviewer.data.core.ConnectionUtilsImpl
import com.jsevilla.movieviewer.data.core.Constants
import com.jsevilla.movieviewer.data.network.end_points.EndPoints
import com.jsevilla.movieviewer.data.network.end_points.EndPointsImpl
import com.jsevilla.movieviewer.data.network.end_points.EndPointsService
import com.jsevilla.movieviewer.data.network.end_points.SupportInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

val networkModule = module {
    single<ConnectionUtils> {
        ConnectionUtilsImpl(
            androidContext()
        )
    }
    factory { SupportInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideApi(get()) }
    single { provideRetrofit(get()) }
    single<EndPoints> { EndPointsImpl(get(), get()) }
}

fun provideOkHttpClient(authInterceptor: SupportInterceptor): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(interceptor)
        .connectTimeout(Constants.Interceptor.TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(Constants.Interceptor.TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
    return builder.build()
}

fun provideApi(retrofit: Retrofit): EndPointsService = retrofit.create(EndPointsService::class.java)

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
