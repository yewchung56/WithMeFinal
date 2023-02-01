package com.example.withmehome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewmeetBinding


class meetRecyclerItemAdapter(var items: List<meetUserdata>) : RecyclerView.Adapter<meetRecyclerItemAdapter.ViewHolder>() {

    private lateinit var itemBinding: ItemViewmeetBinding

    inner class ViewHolder(private val itemBinding: ItemViewmeetBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: meetUserdata){
            itemBinding.title.text = data.title
            itemBinding.name.text = data.name
            itemBinding.date.text = data.date
            itemBinding.like.text= data.like
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = ItemViewmeetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    fun setData(data: List<meetUserdata>){
        items = data
        notifyDataSetChanged()
    }

}