package com.example.me.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.base.BaseFragment
import com.example.me.R
import com.example.me.databinding.FragmentMeBinding

class MeFragment : BaseFragment() {

    companion object {
        fun newInstance() = MeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewBinding = FragmentMeBinding.bind(view)
        viewBinding.title.text = "小明"
        viewBinding.me1.text = "支付"
        viewBinding.me2.text = "收藏"
        viewBinding.me3.text = "相册"
        viewBinding.me4.text = "卡包"
        viewBinding.me5.text = "表情"
        viewBinding.me6.text = "设置"
    }
}