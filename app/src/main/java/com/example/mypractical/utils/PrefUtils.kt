package com.example.mypractical.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Handles Shared Preferences through out the App
 */
@Suppress("unused")
class PrefUtils @Inject constructor(context: Context) {

    private val mPref = context.getSharedPreferences(Constant.APP_PREFERENCES, Context.MODE_PRIVATE)
    //
    private val USER_NAME = "user_name"

    /**
     * Method to clear All Stored Preferences
     */
    fun clearAll() {
        val mEditor = mPref.edit()
        mEditor.clear()
        mEditor.apply()
    }

    fun getUserName(): String? {
        return mPref.getString(USER_NAME,"")
    }

    fun saveUserName(userName: String) {
        LogM.d("==> User name is ??? $userName")
        val editor: SharedPreferences.Editor = mPref.edit()
        editor.putString(USER_NAME, userName)
        editor.apply()
    }
}