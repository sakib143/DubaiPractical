package com.example.mypractical.data.model


import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("isSuccess")
    val isSuccess: Boolean = false,
    @SerializedName("messsage")
    val messsage: String = ""
)