package com.example.mypractical.ui.home

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.mypractical.data.model.MoviesModel

import com.example.mypractical.MyApp
import com.example.mypractical.api.ApiExceptions
import com.example.mypractical.api.NoInternetException
import com.example.mypractical.data.model.UpdateListModel
import com.example.mypractical.data.repository.HomeRepository
import com.example.mypractical.utils.Constant
import com.example.mypractical.utils.Coroutines
import com.example.mypractical.utils.LogM
import com.example.mypractical.utils.PrefUtils
import com.google.gson.JsonObject


import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val application: MyApp,
    private val prefUtils: PrefUtils,
) : AndroidViewModel(application) {

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _moviesList = MutableLiveData<List<MoviesModel.Data>>()
    val moviesList: LiveData<List<MoviesModel.Data>> get() = _moviesList

    private val _updateList = MutableLiveData<UpdateListModel>()
    val updateList: LiveData<UpdateListModel> get() = _updateList

    init {
        callMoviesList()
    }

    fun callMoviesList() {
        Coroutines.main {
            val loginParam = JsonObject()
            loginParam.addProperty(Constant.REQUEST_USERNAME, prefUtils.getUserName())
            try {
                _isViewLoading.postValue(true)
                val apiResponse = repository.callMoviesList(loginParam)
                _isViewLoading.postValue(false)
                _moviesList.postValue(apiResponse.data)
            } catch (e: ApiExceptions) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            }
        }
    }

    fun callUpdateFavouriteStatus(position: Int) {
        Coroutines.main {
            val movieId = _moviesList.value?.get(position)?.movieId
            val inputParam = JsonObject()
            inputParam.addProperty(Constant.REQUEST_USERNAME, prefUtils.getUserName())
            inputParam.addProperty(Constant.REQUEST_MOVIE_ID, movieId)
            try {
                _isViewLoading.postValue(true)
                val apiResponse = repository.callAddOrRemoveFavourite(inputParam)
                if (apiResponse.message.contains("remov", ignoreCase = true)) {
                    _updateList.postValue(UpdateListModel(position,true))
                } else {
                    _updateList.postValue(UpdateListModel(position,true))
                }
                _isViewLoading.postValue(false)
            } catch (e: ApiExceptions) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            }
        }
    }
}