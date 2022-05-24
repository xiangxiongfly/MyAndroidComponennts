package com.example.chat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.bean.ChatBean
import com.example.chat.databinding.ItemChatBinding

class ChatAdapter(val mContext: Context, val mDatas: ArrayList<ChatBean>) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(mContext)
    private var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemViewBinding = ItemChatBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemViewBinding.userPhoto.setImageResource(mDatas[position].userPhoto)
        holder.itemViewBinding.chatMsg.text = mDatas[position].chatMsg
        holder.itemViewBinding.root.setOnClickListener {
            mOnItemClickListener?.onClick(position)
        }
    }

    override fun getItemCount(): Int = mDatas.size

    class ViewHolder(val itemViewBinding: ItemChatBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)

    public interface OnItemClickListener {
        fun onClick(position: Int)
    }

    public fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }
}