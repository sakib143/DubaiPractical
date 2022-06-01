package com.example.mypractical.api

import com.example.mypractical.data.model.FavouriteMovieModel
import com.example.mypractical.data.model.LoginModel
import com.example.mypractical.data.model.MoviesModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * REST API access points
 */
interface WebServiceInterface {


    @POST("login/login")
    suspend fun callLogin(@Body inputParam: JsonObject): Response<LoginModel>

    @POST("movies/movies")
    suspend fun callMoviesList(@Body inputParam: JsonObject): Response<MoviesModel>


    @POST("movies/modify_favourite")
    suspend fun callAddOrRemoveFavourite(@Body inputParam: JsonObject): Response<FavouriteMovieModel>

}