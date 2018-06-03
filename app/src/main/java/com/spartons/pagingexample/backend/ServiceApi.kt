package com.spartons.pagingexample.backend

import com.spartons.pagingexample.reponse.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET(value = "popular")
    fun getPopular(@Query(value = "api_key", encoded = false) apiKey: String, @Query(value = "page", encoded = false) page: Int): Call<MovieResponse>
}