package com.example.find

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseActivity
import com.example.find.databinding.ActivityRunFindBinding

@Route(path = ARouterConstant.PATH_FIND_RUN)
class RunFindActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityRunFindBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}