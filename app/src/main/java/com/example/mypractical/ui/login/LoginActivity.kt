package com.example.mypractical.ui.login

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mypractical.data.model.LoginModel
import com.example.mainactivity.ui.login.LoginViewModel
import com.example.mypractical.R
import com.example.mypractical.base.BaseBindingActivity
import com.example.mypractical.databinding.ActivityLoginBinding
import com.example.mypractical.utils.toast
import javax.inject.Inject

class LoginActivity : BaseBindingActivity<ActivityLoginBinding>() {

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun layoutId() = R.layout.activity_login

    override fun initializeBinding(binding: ActivityLoginBinding) {
        binding.lifecycleOwner = this
        binding.listner = this
        binding.viewmodel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loginModel.observe(this, loginObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)

        /**
         * If user already login, then redirect to home screen.
         */
        if( ! prefUtils.getUserName().isNullOrEmpty()) {
            navigationController.navigateToHome(this@LoginActivity)
        }
    }

    private val loginObserver = Observer<LoginModel> {
        if(it.isSuccess) {
            toast(it.messsage)
            //Save date to share preference
            prefUtils.saveUserName(viewModel.userName.value!!)
            navigationController.navigateToHome(this@LoginActivity)
        } else {
            toast(it.messsage)
        }
    }

    private val onMessageErrorObserver = Observer<Any> {
        toast(it.toString())
    }

}