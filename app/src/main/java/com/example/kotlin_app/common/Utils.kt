package com.example.kotlin_app.common

import coil.network.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

inline fun <T> safeApiCall(
    crossinline fetch: suspend () -> T,
): Flow<Resource<T>> = flow {
    try {
        emit(Resource.Loading())
        val result = fetch()
        emit(Resource.Success(result))
    } catch (e: HttpException) {
        emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
    } catch (e: IOException) {
        emit(Resource.Error("Couldn't reach server. Check your internet connection."))
    }
}