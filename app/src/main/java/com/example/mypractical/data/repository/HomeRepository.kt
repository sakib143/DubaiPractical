package com.example.mypractical.data.repository

import com.example.mypractical.data.model.FavouriteMovieModel
import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.api.SafeAPIRequest
import com.example.mypractical.api.WebServiceInterface
import com.google.gson.JsonObject
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    suspend fun callMoviesList(inputParam: JsonObject): MoviesModel {
        return apiRequest {
            webServiceInterface.callMoviesList(inputParam)
        }
    }

    suspend fun callAddOrRemoveFavourite(inputParam: JsonObject): FavouriteMovieModel {
        return apiRequest {
            webServiceInterface.callAddOrRemoveFavourite(inputParam)
        }
    }
}