package com.example.kotlintutorial.base

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {
    const val BASE_URL = "http://demo9487644.mockable.io/"
    const val BASE_SERVER_URL = "https://api.themoviedb.org/3/"

    private val instance: Retrofit
        private get() = Retrofit.Builder().baseUrl(BASE_SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    private val instanceAdver: Retrofit
        private get() = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    @JvmStatic
    val filmApi: FilmApi
        get() = instance.create(FilmApi::class.java)
    val adver: FilmApi
        get() = instanceAdver.create(FilmApi::class.java)
}