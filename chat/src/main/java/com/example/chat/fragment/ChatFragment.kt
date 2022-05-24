package com.example.chat.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chat.R
import com.example.chat.adapter.ChatAdapter
import com.example.chat.bean.ChatBean
import com.example.chat.databinding.FragmentChatBinding
import com.example.chat.info.ChatInfoActivity
import com.example.common.base.BaseFragment

class ChatFragment : BaseFragment(), ChatAdapter.OnItemClickListener {

    private lateinit var mContext: Context
    private lateinit var viewBinding: FragmentChatBinding
    private var mAdapter: ChatAdapter? = null
    private val mDatas = ArrayList<ChatBean>()

    companion object {
        fun newInstance() = ChatFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentChatBinding.bind(view)
        viewBinding.chatList.apply {
            layoutManager = LinearLayoutManager(mContext)
            addItemDecoration(DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL))
            mAdapter = ChatAdapter(mContext, mDatas)
            mAdapter?.setOnItemClickListener(this@ChatFragment)
            adapter = mAdapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }

    private fun loadData() {
        mDatas.add(ChatBean(R.mipmap.ic_launcher, "chat组件化"))
        mDatas.add(ChatBean(R.mipmap.ic_launcher_round, "你好"))
        mDatas.add(ChatBean(R.mipmap.ic_launcher, "hello world"))
        mDatas.add(ChatBean(R.mipmap.ic_launcher_round, "欢迎欢迎"))
        mAdapter?.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {
        ChatInfoActivity.start(mContext, mDatas[position].userPhoto, mDatas[position].chatMsg)
    }

}