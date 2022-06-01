package com.example.mypractical.data.model


import com.google.gson.annotations.SerializedName

data class FavouriteMovieModel(
    @SerializedName("data")
    val `data`: Any = Any(),
    @SerializedName("message")
    val message: String = ""
)