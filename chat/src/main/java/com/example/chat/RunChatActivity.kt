package com.example.chat

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseActivity

@Route(path = ARouterConstant.PATH_CHAT_RUN)
class RunChatActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_chat)
    }
}