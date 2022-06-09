package com.example.kotlintutorial.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val homeRepository = HomeRepository(application)

    lateinit var mUpComingLiveData: MutableLiveData<ResultResponse>

    fun getUpcomingMovie(apiKey: String, page: Int) {
        homeRepository.fetchUpComingFilm(apiKey, page)
    }
}