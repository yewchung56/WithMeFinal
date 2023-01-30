package com.example.withmehome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewmessage2Binding

class MRecyclerItemAdapter2(var items: List<MUserdata>) : RecyclerView.Adapter<MRecyclerItemAdapter2.ViewHolder>() {

    private lateinit var itemBinding: ItemViewmessage2Binding

    inner class ViewHolder(private val itemBinding: ItemViewmessage2Binding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: MUserdata){
            itemBinding.name.text = data.name
            itemBinding.content.text = data.content
            itemBinding.date.text = data.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = ItemViewmessage2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    fun setData(data: List<MUserdata>){
        items = data
        notifyDataSetChanged()
    }

}