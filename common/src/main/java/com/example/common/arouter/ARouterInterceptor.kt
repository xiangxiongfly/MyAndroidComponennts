package com.example.common.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

@Interceptor(priority = 8, name = "ARouterInterceptor")
class ARouterInterceptor : IInterceptor {
    override fun init(context: Context?) {
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        //判断条件
        var isOpen = true
        if (isOpen) {
            //不拦截
            callback?.onContinue(postcard)
        } else {
            //拦截
            callback?.onInterrupt(Throwable("拦截"))
        }
    }
}