package com.example.mypractical.data.repository

import com.example.mypractical.data.model.LoginModel
import com.example.mypractical.api.SafeAPIRequest
import com.example.mypractical.api.WebServiceInterface
import com.example.mypractical.utils.LogM
import com.google.gson.JsonObject
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    suspend fun callLogin(inputParam: JsonObject): LoginModel {

        LogM.d("==> input param ${inputParam}")

        return apiRequest {
            webServiceInterface.callLogin(inputParam)
        }
    }
}