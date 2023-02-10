package com.example.withmehome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewreview2Binding

class ReviewRecyclerItemAdapter2(var items: List<ReviewUserdata>) : RecyclerView.Adapter<ReviewRecyclerItemAdapter2.ViewHolder>() {

    private lateinit var itemBinding: ItemViewreview2Binding

    inner class ViewHolder(private val itemBinding: ItemViewreview2Binding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: ReviewUserdata){
            itemBinding.title.text = data.title
            itemBinding.name.text = data.name
            itemBinding.date.text = data.date
            itemBinding.content.text= data.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = ItemViewreview2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    fun setData(data: List<ReviewUserdata>){
        items = data
        notifyDataSetChanged()
    }

}
