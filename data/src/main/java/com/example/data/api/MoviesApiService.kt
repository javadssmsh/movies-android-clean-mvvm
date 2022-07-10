package com.example.data.api

import com.example.data.model.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {


    @GET("v2/top-headlines")
    suspend fun getBatmanMovies(
        @Query("apikey")
        apikey: String = "3e974fca",
        @Query("s")
        name: String = "batman",
    ): Response<MoviesResponse>
}