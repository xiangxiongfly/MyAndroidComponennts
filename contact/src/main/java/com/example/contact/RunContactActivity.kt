package com.example.contact

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseActivity
import com.example.contact.databinding.ActivityRunContactBinding

@Route(path = ARouterConstant.PATH_CONTACT_RUN)
class RunContactActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityRunContactBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}