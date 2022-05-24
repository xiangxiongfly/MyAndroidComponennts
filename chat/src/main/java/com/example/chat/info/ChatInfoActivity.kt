package com.example.chat.info

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.chat.constant.IntentKey
import com.example.chat.databinding.ActivityChatInfoBinding
import com.example.common.base.BaseActivity
import com.example.common.utils.ToastUtils

class ChatInfoActivity : BaseActivity() {
    private lateinit var binding: ActivityChatInfoBinding

    companion object {
        fun start(context: Context, userPhoto: Int, chatMsg: String) {
            context.startActivity(Intent(context, ChatInfoActivity::class.java).apply {
                putExtra(IntentKey.CHAT_MSG, chatMsg)
                putExtra(IntentKey.USER_PHOTO, userPhoto)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "聊天详情"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initExtras()
    }

    private fun initExtras() {
        val chatMsg = intent.getStringExtra(IntentKey.CHAT_MSG)
        val userPhoto = intent.getIntExtra(IntentKey.USER_PHOTO, -1)
        binding.detail.text = chatMsg
        binding.detail.setOnClickListener {
            ToastUtils.show(binding.detail.text.toString())
        }
        binding.userPhoto.setImageResource(userPhoto)
    }
}