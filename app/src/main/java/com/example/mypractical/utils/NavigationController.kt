package com.example.mypractical.utils

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.example.mypractical.base.BaseActivity
import com.example.mypractical.ui.home.HomeActivity
import javax.inject.Inject

/**
 * Class That Handles all Navigation between Activities
 */
class NavigationController @Inject constructor(var context: Context) {

    /**
    //     * Opens Details screen
    //     * @param activity -> to Start the Activity
    //     */
    fun navigateToHome(
        activity: BaseActivity) {
        activity.startActivity(HomeActivity.intentFor(context))
    }

}