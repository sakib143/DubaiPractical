package com.example.mainactivity.ui.login

import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.mypractical.data.model.LoginModel

import com.example.mypractical.MyApp
import com.example.mypractical.R
import com.example.mypractical.api.ApiExceptions
import com.example.mypractical.api.NoInternetException
import com.example.mypractical.data.repository.LoginRepository
import com.example.mypractical.utils.Constant
import com.example.mypractical.utils.Coroutines
import com.example.mypractical.utils.toast
import com.google.gson.JsonObject
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val application: MyApp,
) : AndroidViewModel(application) {

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _loginModel = MutableLiveData<LoginModel>()
    val loginModel: LiveData<LoginModel> get() = _loginModel

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    fun callLogin(): LiveData<LoginModel> {
        Coroutines.main {
            if (isValidData()) {
                Coroutines.main {
                    val loginParam = JsonObject()
                    loginParam.addProperty(Constant.REQUEST_USERNAME, _userName.value)
                    loginParam.addProperty(Constant.REQUEST_PASSWORD, _password.value)
                    try {
                        _isViewLoading.postValue(true)
                        val apiResponse = repository.callLogin(loginParam)
                        _isViewLoading.postValue(false)
                        _loginModel.postValue(apiResponse)
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
        return _loginModel
    }

    fun isValidData(): Boolean {
        var isValid = true
        if (_userName.value.isNullOrBlank()) {
            application.toast(application.getString(R.string.enter_user_name))
            return false
        } else if (_password.value.isNullOrBlank()) {
            application.toast(application.getString(R.string.enter_password))
            return false
        }
        return isValid
    }

    fun onUerNameChange(editable: Editable?) {
        _userName.postValue(editable.toString())
    }

    fun onPasswrodChange(editable: Editable?) {
        _password.postValue(editable.toString())
    }

}