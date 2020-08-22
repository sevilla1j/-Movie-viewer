package com.jsevilla.movieviewer.data.mock

import com.jsevilla.movieviewer.data.BuildConfig
import com.jsevilla.movieviewer.data.core.ConnectionUtils
import com.jsevilla.movieviewer.data.network.end_points.EndPoints
import com.jsevilla.movieviewer.data.network.end_points.EndPointsImpl
import com.jsevilla.movieviewer.data.network.end_points.EndPointsService
import com.jsevilla.movieviewer.data.network.end_points.SupportInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
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

val fakeNetworkModule = module {
    single { ConnectionUtilsImplMocked() } bind ConnectionUtils::class
    factory { SupportInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideApi(get()) }
    single { provideRetrofit(get()) }
    single<EndPoints> { EndPointsImpl(get(), get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(authInterceptor: SupportInterceptor): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(interceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
    return builder.build()
}

fun provideApi(retrofit: Retrofit): EndPointsService = retrofit.create(EndPointsService::class.java)
