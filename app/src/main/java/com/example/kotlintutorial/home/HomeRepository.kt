package com.example.kotlintutorial.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.kotlintutorial.base.NetworkState
import com.example.kotlintutorial.base.RetrofitClass
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class HomeRepository(application: Application) {
    val TAG: String = "TAG"
    val upComingLiveData = MutableLiveData<ResultResponse>()
    val comingSoonLiveData = MutableLiveData<ResultResponse>()
    val mNetworkState = MutableLiveData<NetworkState>()

    fun fetchNowPlayingFilm(apiKey: String?, page: Int) {
        mNetworkState.postValue(NetworkState.LOADING)
        val filmApi = RetrofitClass.filmApi
        filmApi.getUpcomingFilmResponse(apiKey, page)?.subscribeOn(Schedulers.io())
            ?.timeout(30000, TimeUnit.MILLISECONDS)?.subscribe(object : Observer<ResultResponse?> {
            override fun onNext(t: ResultResponse) {
                upComingLiveData.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                mNetworkState.postValue(NetworkState.FAILED)
            }

            override fun onComplete() {
                mNetworkState.postValue(NetworkState.LOADED)
            }
        })
    }

    fun getNowPlayingFilmLiveData(): MutableLiveData<ResultResponse> {
        return upComingLiveData
    }


}