package com.example.kotlintutorial.home

import android.app.Application
import android.database.Observable
import android.graphics.pdf.PdfDocument
import androidx.lifecycle.MutableLiveData
import com.example.kotlintutorial.base.RetrofitClass
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class HomeRepository(application: Application) {
    val TAG: String = "TAG"
    val upComingLiveData = MutableLiveData<ResultResponse>()
    val comingSoonLiveData = MutableLiveData<ResultResponse>()

    fun fetchUpComingFilm(apiKey: String, page: Int) {
        val filmApi = RetrofitClass.filmApi
        val observableUpComing = filmApi.getUpcomingFilmResponse(apiKey, page)
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<ResultResponse> {
                override fun onSubscribe(d: Disposable) {
                    TODO("Not yet implemented")
                }

                override fun onNext(t: ResultResponse) {
                    TODO("Not yet implemented")
                    upComingLiveData.postValue(t)
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })
    }
    fun getUpComingFilmLiveData(): MutableLiveData<ResultResponse> {
        return upComingLiveData
    }


}