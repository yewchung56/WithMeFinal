package com.example.withmehome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewchoBinding

class choRecyclerItemAdapter(var items: List<choUserdata>) : RecyclerView.Adapter<choRecyclerItemAdapter.ViewHolder>() {

    private lateinit var itemBinding: ItemViewchoBinding

    inner class ViewHolder(private val itemBinding: ItemViewchoBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: choUserdata){
            itemBinding.name.text = data.name
            itemBinding.place.text = data.place
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = ItemViewchoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    fun setData(data: List<choUserdata>){
        items = data
        notifyDataSetChanged()
    }

}