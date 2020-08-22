package com.jsevilla.movieviewer.data.network.end_points

import com.jsevilla.movieviewer.data.BuildConfig
import com.jsevilla.movieviewer.data.core.ConnectionUtils
import com.jsevilla.movieviewer.data.core.Constants
import com.jsevilla.movieviewer.data.network.response.MovieBodyResponse
import com.jsevilla.movieviewer.data.network.response.MovieResponse
import com.jsevilla.movieviewer.domain.entity.Either
import com.jsevilla.movieviewer.domain.entity.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class EndPointsImpl(
    private val endPoints: EndPointsService,
    private val networkUtils: ConnectionUtils
) : EndPoints {

    override suspend fun getMovies(): Either<Failure, MovieResponse> =
        callService { endPoints.getMovies(BuildConfig.TokenTMDb, 1) }

    override suspend fun getMovie(movieId: Int): Either<Failure, MovieBodyResponse> =
        callService { endPoints.getMovie(movieId, BuildConfig.TokenTMDb) }

    private suspend inline fun <T> callService(crossinline retrofitCall: suspend () -> Response<T>): Either<Failure, T> {
        return when (networkUtils.isNetworkAvailable()) {
            true -> {
                try {
                    withContext(Dispatchers.IO) {
                        val response = retrofitCall.invoke()
                        if (response.isSuccessful && response.body() != null) {
                            return@withContext Either.Right(response.body()!!)
                        } else {
                            return@withContext Either.Left(
                                getErrorMessageFromServer(
                                    response.errorBody()?.toString()
                                )
                            )
                        }
                    }
                } catch (e: Exception) {
                    return Either.Left(parseException(e))
                }
            }
            false -> Either.Left(Failure.NoNetworkDetected)
        }
    }

    private suspend fun getErrorMessageFromServer(errorBody: String?): Failure {
        return if (errorBody != null) {
            return withContext(Dispatchers.IO) {
                val serverErrorJson = JSONObject(errorBody)
                when {
                    isServerErrorValid(serverErrorJson.toString()) -> {
                        val code = serverErrorJson[Constants.EndPoints.KEY_CODE].toString().toInt()
                        if (code == Constants.CodeError.ERROR401 || code == Constants.CodeError.ERROR403) {
                            return@withContext Failure.UnauthorizedOrForbidden
                        } else {
                            return@withContext Failure.ServerBodyError(
                                code,
                                serverErrorJson[Constants.EndPoints.KEY_MESSAGE].toString()
                            )
                        }
                    }
                    serverErrorJson.toString().contains("\"$Constants.EndPoints.KEY_MESSAGE\"") -> {
                        return@withContext Failure.ServiceUncaughtFailure(
                            serverErrorJson[Constants.EndPoints.KEY_MESSAGE].toString()
                        )
                    }
                    else -> return@withContext Failure.None
                }
            }
        } else {
            //No error body was found.
            Failure.None
        }
    }

    private fun isServerErrorValid(error: String): Boolean {
        return error.contains("\"${Constants.EndPoints.KEY_CODE}\"")
                && error.contains("\"${Constants.EndPoints.KEY_MESSAGE}\"")
    }

    private fun parseException(throwable: Throwable): Failure {
        return when (throwable) {
            is SocketTimeoutException -> Failure.TimeOut
            is SSLException -> Failure.NetworkConnectionLostSuddenly
            is SSLHandshakeException -> Failure.SSLError
            else -> Failure.ServiceUncaughtFailure(
                throwable.message ?: "Service response doesn't match with response object."
            )
        }
    }
}
