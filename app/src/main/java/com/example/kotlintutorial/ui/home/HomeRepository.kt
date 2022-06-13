package com.example.kotlintutorial.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlintutorial.base.NetworkState
import com.example.kotlintutorial.base.RetrofitClass
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class HomeRepository(application: Application) {
    val TAG: String = "HomeRepository"
    val nowPlayingLiveData = MutableLiveData<ResultResponse>()
    val comingSoonLiveData = MutableLiveData<ResultResponse>()
    val mNetworkState = MutableLiveData<NetworkState>()
    private val filmApi = RetrofitClass.filmApi

    fun fetchNowPlayingFilm(apiKey: String?, page: Int) {
        mNetworkState.postValue(NetworkState.LOADING)
        filmApi.getPopularFilmResponse(apiKey, page)?.subscribeOn(Schedulers.io())
            ?.timeout(30000, TimeUnit.MILLISECONDS)?.subscribe(object : Observer<ResultResponse?> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onNext(t: ResultResponse) {
                    nowPlayingLiveData.postValue(t)
                }

                override fun onError(e: Throwable) {
                    mNetworkState.postValue(NetworkState.FAILED)
                    Log.d(TAG, "onError")
                }

                override fun onComplete() {
                    mNetworkState.postValue(NetworkState.LOADED)
                    Log.d(TAG, "onComplete")
                }
            })
    }

    fun getNowPlayingFilmLiveData(): MutableLiveData<ResultResponse> {
        return nowPlayingLiveData
    }

    fun fetchComingSoonFilm(apiKey: String?, page: Int) {
        mNetworkState.postValue(NetworkState.LOADING)
        filmApi.getUpcomingFilmResponse(apiKey, page)?.subscribeOn(Schedulers.io())
            ?.timeout(30000, TimeUnit.MILLISECONDS)?.subscribe(object : Observer<ResultResponse?> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onNext(t: ResultResponse) {
                    comingSoonLiveData.postValue(t)
                }

                override fun onError(e: Throwable) {
                    mNetworkState.postValue(NetworkState.FAILED)
                    Log.d(TAG, "onError")
                }

                override fun onComplete() {
                    mNetworkState.postValue(NetworkState.LOADED)
                    Log.d(TAG, "onComplete")
                }

            })
    }

    fun getComingSoonFilmLiveData() : MutableLiveData<ResultResponse> {
        return comingSoonLiveData
    }


}