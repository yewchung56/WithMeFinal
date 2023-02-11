package com.example.withmehome

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.MessageSharingMyChatBinding
import com.example.withmehome.databinding.MessageSharingYourChatBinding
import java.text.SimpleDateFormat
import java.util.*

class ChatAdapter(private val auth: String):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<ChatModel>(){
            override fun areItemsTheSame(oldItem: ChatModel, newItem: ChatModel): Boolean{
                return oldItem == newItem
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: ChatModel, newItem: ChatModel) : Boolean{
                return oldItem == newItem
            }
        }
        private const val MY_CHAT = 1
        private const val OTHER_CHAT = 2
    }
    val currentList = arrayListOf<ChatModel>()
    override fun getItemViewType(position: Int): Int {
        return if (auth == currentList[position].senderId)
            MY_CHAT
        else OTHER_CHAT
    }

    inner class MyChatItemViewHolder(private val binding: MessageSharingMyChatBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(chat: ChatModel){
            val dateFormat = SimpleDateFormat("HH:mm" , Locale.getDefault())
            val date = Date(chat.date_time)
            binding.messageMyChatContents.text = chat.script
            binding.messageMyChatTime.text = dateFormat.format(date)
        }
    }
    inner class OtherChatItemViewHolder(private val binding: MessageSharingYourChatBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(chat: ChatModel){
            val dateFormat = SimpleDateFormat("HH:mm" , Locale.getDefault())
            val date = Date(chat.date_time)
            binding.messageYourChatContents.text = chat.script
            binding.messageYourChatTime.text = dateFormat.format(date)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == MY_CHAT){
            MyChatItemViewHolder(
                MessageSharingMyChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        } else{
            OtherChatItemViewHolder(
                MessageSharingYourChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == MY_CHAT){
            (holder as MyChatItemViewHolder).bind(currentList[position])
        }else{
            (holder as OtherChatItemViewHolder).bind(currentList[position])
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}