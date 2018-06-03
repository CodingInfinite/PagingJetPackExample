package com.spartons.pagingexample.reponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieResponse {

    @SerializedName(value = "page")
    @Expose
    var page: Int = 0
    @SerializedName(value = "results")
    @Expose
    var movies: List<Movie> = ArrayList()

    class Movie {

        @SerializedName(value = "title")
        @Expose
        var title: String = ""
        @SerializedName(value = "vote_average")
        @Expose
        var voteAverage: Double = 0.0
        @SerializedName(value = "poster_path")
        @Expose
        var posterPath: String = ""
        @SerializedName(value = "release_date")
        @Expose
        var releaseDate: String = ""
    }
}