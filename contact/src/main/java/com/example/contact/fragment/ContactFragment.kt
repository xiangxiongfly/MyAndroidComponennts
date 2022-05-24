package com.example.contact.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.base.BaseFragment
import com.example.common.event.EventMessage
import com.example.contact.R
import com.example.contact.databinding.FragmentContactBinding
import org.greenrobot.eventbus.EventBus

class ContactFragment : BaseFragment() {

    private lateinit var mContext: Context

    companion object {
        fun newInstance() = ContactFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewBinding = FragmentContactBinding.bind(view)
        viewBinding.contact1.text = "新朋友"
        viewBinding.contact2.text = "群聊"
        viewBinding.contact3.text = "标签"
        viewBinding.contact4.text = "公众号"
        viewBinding.sendEventBus.setOnClickListener {
            EventBus.getDefault().post(EventMessage(1, "hello EventBus"))
        }
        viewBinding.sendBroadcast.setOnClickListener {
            mContext.sendBroadcast(Intent("com.example.module.data").putExtra("data", "hello 广播"))

        }
    }


}