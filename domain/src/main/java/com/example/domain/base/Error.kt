package com.example.domain.base

sealed class Error {

    // server
    object Internet : Error() // retrofit timeout

    data class ServerError(val message: String?) : Error() // 4xx

    object Unknown : Error() // 5xx

    object TokenExpired : Error() // 401

    object NotFound : Error() // 404

    object NotLoggedIn : Error() // refresh token is empty

    object EmptyResult : Error() // 200 but without and data

}