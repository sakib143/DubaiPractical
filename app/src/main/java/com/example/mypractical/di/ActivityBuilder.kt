package com.example.mypractical.di


//import com.example.mypractical.ui.main.MainActivity
import com.example.mypractical.ui.home.HomeActivity
import com.example.mypractical.ui.login.LoginActivity
import com.example.mypractical.utils.Coroutines.main
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Helps to generate an {@link AndroidInjector} for all activities
 * */
@Suppress("unused")
@Module
abstract class ActivityBuilder {

    /**
     * fun to bind LoginActivity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindLoginActivity() : LoginActivity

    /**
     * fun to bind HomeActivity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindHomeActivity() : HomeActivity
}