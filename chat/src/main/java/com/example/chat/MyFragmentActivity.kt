package com.example.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.example.chat.databinding.ActivityMyFragmentBinding
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseActivity

class MyFragmentActivity : BaseActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MyFragmentActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMyFragmentBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val fragment =
            ARouter.getInstance().build(ARouterConstant.PATH_FIND_FRAGMENT)
                .withString("name", "hello world")
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }
}