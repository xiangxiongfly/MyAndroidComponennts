package com.example.me

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseActivity
import com.example.me.databinding.ActivityRunMeBinding

@Route(path = ARouterConstant.PATH_ME_RUN)
class RunMeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityRunMeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}