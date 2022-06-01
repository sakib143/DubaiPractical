package com.example.mypractical.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.example.mainactivity.ui.login.LoginViewModel
import com.example.mypractical.R
import com.example.mypractical.base.BaseBindingActivity
import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.databinding.ActivityHomeBinding
import com.example.mypractical.databinding.ActivityLoginBinding
import com.example.mypractical.listner.HomeListner
import com.example.mypractical.utils.toast
import javax.inject.Inject

class HomeActivity :  BaseBindingActivity<ActivityHomeBinding>(), HomeListner {

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun layoutId() = R.layout.activity_home

    override fun initializeBinding(binding: ActivityHomeBinding) {
        binding.lifecycleOwner = this
        binding.listner = this
        binding.viewmodel = viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun intentFor(context: Context) =
            Intent(
                context,
                HomeActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }

    override fun updateFavourites(position: Int) {
        viewModel.callUpdateFavouriteStatus(position)
    }
}