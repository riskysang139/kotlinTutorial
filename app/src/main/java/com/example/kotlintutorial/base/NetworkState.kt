package com.example.kotlintutorial.base

class NetworkState(status: Status) {
    enum class Status {
        RUNNING, SUCCESS, ERROR
    }

    companion object {
        val LOADING: NetworkState = NetworkState(Status.RUNNING)
        val LOADED: NetworkState = NetworkState(Status.SUCCESS)
        val FAILED: NetworkState = NetworkState(Status.ERROR)
    }
}