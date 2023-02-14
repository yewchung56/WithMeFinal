package com.example.withmehome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.withmehome.databinding.ItemView2Binding
import com.example.withmehome.databinding.ItemViewBinding
import com.example.withmehome.databinding.ItemViewlikeBinding


class LikeRecyclerItemAdapter(var items: List<LUserdata>) : RecyclerView.Adapter<ViewHolder>() {

    private lateinit var itemBinding: ItemViewlikeBinding
    private lateinit var itemBinding2: ItemViewlike2Binding

    inner class MultiViewHolder1(private val itemBinding: ItemViewlikeBinding): ViewHolder(itemBinding.root){
        fun bind(data: LUserdata){
            itemBinding.title.text = data.title
            itemBinding.name.text = data.name
            itemBinding.date.text = data.date
            itemBinding.like.text = data.like
        }
    }
    inner class MultiViewHolder2(private val itemBinding2: ItemViewlike2Binding): ViewHolder(itemBinding.root){
        fun bind(data: LUserdata){
            itemBinding2.title.text = data.title
            itemBinding2.name.text = data.name
            itemBinding2.date.text = data.date
            itemBinding2.like.text = data.like
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            multi_type1 -> {
                itemBinding = ItemViewlikeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder1(itemBinding)

            }
            else -> {
                itemBinding2 = ItemView2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder2(itemBinding2)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when(items[position].type) {
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(items[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as MultiViewHolder2).bind(items[position])
                holder.setIsRecyclable(false)
            }
        }
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
