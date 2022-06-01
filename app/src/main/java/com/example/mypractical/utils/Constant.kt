package com.example.mypractical.utils

/**
 * Class Contains All the Constant Values which will be used through out App
 */
class Constant {

    companion object {
        const val DATE_FORMAT = "dd/MM/yy h:mm"
        const val DATE_FORMAT_ONE = "yyyy-MM-dd'T'HH:mm:ss"
        const val DATE_FORMAT_YY_MM_DD = "yyyy-MM-dd"
        const val CHECK_INTERNET = "Please check your internet connection"
        const val DEFAULT_SERVER_ERROR = "Something went wrong on server side. Please try again."
        const val APP_PREFERENCES = "app_preferences"
        const val SOCKET_TIMEOUT_EXCEPTIONS = "Poor connectivity. Please try again later."
        const val CONNECTION_TIMEOUT_EXCEPTIONS = "Connection Timeout Exception"
        const val SUCCESS_CODE = 200
        const val UNAUTHORIZED_CODE = 401
        const val INTERNAL_SERVER_ERROR_CODE = 500
        const val NO_DATA_FOUND_CODE = 404
        const val METHOD_NOT_ALLOW = 405
        const val PRE_CONDITION_FAILED = 412
        const val RESPONSE_MESSAGE = "message"

//        const val KEY_MAIN_MODEL = "main_model"

        const val REQUEST_USERNAME = "user_name"
        const val REQUEST_PASSWORD = "password"
        const val REQUEST_MOVIE_ID = "movie_id"



    }
}