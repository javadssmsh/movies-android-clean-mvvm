package com.example.data.base



sealed class NetworkResult<out T: Any> {

    data class Success<out T: Any>(val data: T) : NetworkResult<T>()

    data class Error(val error: Error) : NetworkResult<Nothing>()
}
