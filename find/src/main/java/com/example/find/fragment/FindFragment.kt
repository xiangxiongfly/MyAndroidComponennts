package com.example.find.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.arouter.ARouterConstant
import com.example.common.base.BaseFragment
import com.example.common.event.EventMessage
import com.example.common.utils.ToastUtils
import com.example.find.R
import com.example.find.databinding.FragmentFindBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@Route(path = ARouterConstant.PATH_FIND_FRAGMENT)
class FindFragment : BaseFragment() {

    private var mReceiver: MyReceiver? = null
    private lateinit var mContext: Context

    private lateinit var viewBinding: FragmentFindBinding

    companion object {
        fun newInstance() = FindFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val name = it.getString("name")
            ToastUtils.show(name)
        }
        EventBus.getDefault().register(this)
        registerReceiver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_find, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentFindBinding.bind(view)
        viewBinding.find1.text = "朋友圈"
        viewBinding.find2.text = "扫一扫"
        viewBinding.find3.text = "游戏"
        viewBinding.find4.text = "小程序"
    }

    @Subscribe
    fun onEventMessage(event: EventMessage) {
        if (event.code == 1) {
            viewBinding.getMessage.text = event.message
        }
    }

    inner class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let {
                val data = intent.getStringExtra("data")
                viewBinding.getBroadcast.text = data
            }
        }
    }

    fun registerReceiver() {
        mReceiver = MyReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.module.data")
        mContext.registerReceiver(mReceiver, intentFilter)
    }

    fun unregisterReceiver() {
        mReceiver?.let {
            mContext.unregisterReceiver(it)
        }
        mReceiver = null
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
        unregisterReceiver()
    }
}