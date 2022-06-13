package com.example.kotlintutorial.base

import com.example.kotlintutorial.ui.home.ResultResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApi {
    @GET("movie/popular")
    fun getPopularFilmResponse(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Observable<ResultResponse?>?

    @GET("movie/top_rated")
    fun getTopRatedFilmResponse(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Observable<ResultResponse?>?

    @GET("movie/upcoming")
    fun getUpcomingFilmResponse(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): Observable<ResultResponse?>?
}