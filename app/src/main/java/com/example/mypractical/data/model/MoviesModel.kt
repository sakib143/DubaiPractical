package com.example.mypractical.data.model


import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("data")
    val `data`: List<Data> = listOf(),
    @SerializedName("message")
    val message: String = ""
) {
    data class Data(
        @SerializedName("movie_id")
        val movieId: Int = 0,
        @SerializedName("movie_name")
        val movieName: String = "",
        @SerializedName("status")
        var status: Int = 0
    )
}