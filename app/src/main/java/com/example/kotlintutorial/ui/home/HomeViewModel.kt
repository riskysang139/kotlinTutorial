package com.example.kotlintutorial.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val homeRepository = HomeRepository(application)

    fun fetchNowPlayingFilm(apiKey: String?, page: Int) {
        homeRepository.fetchNowPlayingFilm(apiKey, page)
    }

    fun getNowPlayingFilm (): MutableLiveData<ResultResponse>{
        return homeRepository.getNowPlayingFilmLiveData()
    }

    fun fetchComingSoonFilm(apiKey: String?, page: Int) {
        homeRepository.fetchComingSoonFilm(apiKey, page)
    }

    fun getComingSoonFilm (): MutableLiveData<ResultResponse>{
        return homeRepository.getComingSoonFilmLiveData()
    }

}