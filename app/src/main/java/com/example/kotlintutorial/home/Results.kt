package com.example.kotlintutorial.home

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Results {
    @SerializedName("adult")
    @Expose
    private var adult: Boolean = false

    @SerializedName("backdrop_path")
    @Expose
    private var backdropPath: String = ""

    @SerializedName("genre_ids")
    @Expose
    private var genreIds: List<Int>? = null

    @SerializedName("id")
    @Expose
    private var id: Int? = 0

    @SerializedName("original_language")
    @Expose
    private var originalLanguage: String? = ""

    @SerializedName("original_title")
    @Expose
    private var originalTitle: String? = ""

    @SerializedName("overview")
    @Expose
    private var overview: String? = ""

    @SerializedName("popularity")
    @Expose
    private var popularity: Double? = 0.0

    @SerializedName("poster_path")
    @Expose
    private var posterPath: String? = ""

    @SerializedName("release_date")
    @Expose
    private var releaseDate: String? = ""

    @SerializedName("title")
    @Expose
    private var title: String? = ""

    @SerializedName("video")
    @Expose
    private var video: Boolean? = false

    @SerializedName("vote_average")
    @Expose
    private var voteAverage: Double? = 0.0

    @SerializedName("vote_count")
    @Expose
    private var voteCount: Int? = 0
    private var type = 0


    override fun toString(): String {
        return "Results{" +
                "adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", genreIds=" + genreIds +
                ", id=" + id +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}'
    }


}