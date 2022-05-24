package com.example.common.utils

import android.widget.Toast
import com.example.common.base.BaseApp

object ToastUtils {
    fun show(msg: String?) {
        Toast.makeText(BaseApp.context, msg, Toast.LENGTH_SHORT).show()
    }
}