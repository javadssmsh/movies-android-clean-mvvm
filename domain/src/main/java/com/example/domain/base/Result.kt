package com.example.domain.base

sealed class Result<out T: Any> {

    data class Success<out T: Any>(val data: T) : Result<T>()

    data class Error(val error: com.example.domain.base.Error) : Result<Nothing>()
}