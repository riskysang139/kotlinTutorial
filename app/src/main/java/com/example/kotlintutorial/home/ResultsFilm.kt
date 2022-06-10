package com.example.kotlintutorial.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultsFilm {

    @SerializedName("adult")
    @Expose
    var adult: Boolean = false

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String = ""

    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null

    @SerializedName("id")
    @Expose
    var id: Int? = 0

    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = ""

    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = ""

    @SerializedName("overview")
    @Expose
    var overview: String? = ""

    @SerializedName("popularity")
    @Expose
    var popularity: Double? = 0.0

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = ""

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = ""

    @SerializedName("title")
    @Expose
    var title: String? = ""

    @SerializedName("video")
    @Expose
    var video: Boolean? = false

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double? = 0.0

    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = 0
    var type = 0


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