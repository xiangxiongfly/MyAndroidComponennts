package com.example.common.utils

import android.util.Log

object LogUtils {
    private const val TAG = "TAG"

    fun log(msg: String) = Log.e(TAG, msg)
}