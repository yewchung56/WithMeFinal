package com.example.withmehome

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewlikeBinding
import com.example.withmehome.databinding.ItemViewmessageBinding


class LikeRecyclerItemAdapter(var items: List<LUserdata>) : RecyclerView.Adapter<LikeRecyclerItemAdapter.ViewHolder>() {

    private lateinit var itemBinding: ItemViewlikeBinding

    inner class ViewHolder(private val itemBinding: ItemViewlikeBinding): RecyclerView.ViewHolder(itemBinding.root){
        private val context = itemBinding.root.context
        fun bind(data: LUserdata){
            itemBinding.title.text = data.title
            itemBinding.name.text = data.name
            itemBinding.date.text = data.date
            itemBinding.like.text = data.like



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = ItemViewlikeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(items[position])
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun setData(data: List<LUserdata>){
        items = data
        notifyDataSetChanged()
    }

}
