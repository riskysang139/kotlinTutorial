package com.example.kotlintutorial.home

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.kotlintutorial.home.Results

class ResultResponse {
    @SerializedName("page")
    @Expose
    private var page: Int? = 0
    private var results: List<Results>? = null

    @SerializedName("total_pages")
    @Expose
    private var totalPages: Int? = 0

    @SerializedName("total_results")
    @Expose
    private var totalResults: Int? = 0
}