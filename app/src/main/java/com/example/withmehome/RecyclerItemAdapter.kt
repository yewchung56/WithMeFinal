package com.example.withmehome

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.withmehome.databinding.ItemView2Binding
import com.example.withmehome.databinding.ItemViewBinding


class RecyclerItemAdapter(var items: List<Userdata>) : RecyclerView.Adapter<ViewHolder>() {

    private lateinit var itemBinding: ItemViewBinding
    private lateinit var itemBinding2: ItemView2Binding

    inner class MultiViewHolder1(private val itemBinding: ItemViewBinding): ViewHolder(itemBinding.root){
        private val context = itemBinding.root.context

        fun bind(data: Userdata){
            itemBinding.title.text = data.title
            itemBinding.name.text = data.name
            itemBinding.date.text = data.date
            itemBinding.like.text = data.like
            itemBinding.category.text = data.category

            itemView.setOnClickListener{
                val intent = Intent(context, RecruitmentDetailActivity::class.java)
                intent.run { context.startActivity(this) }
            }
        }
    }
    inner class MultiViewHolder2(private val itemBinding2: ItemView2Binding): ViewHolder(itemBinding2.root){
        private val context2 = itemBinding2.root.context
        fun bind(data: Userdata){
            itemBinding2.title.text = data.title
            itemBinding2.name.text = data.name
            itemBinding2.date.text = data.date
            itemBinding2.like.text = data.like
            itemBinding2.category.text = data.category

            itemView.setOnClickListener{
                val intent = Intent(context2, RecruitmentDetailActivity::class.java)
                intent.run { context2.startActivity(this) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when(viewType){
            multi_type1 -> {
                itemBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder1(itemBinding)

            }
            else -> {
                itemBinding2 = ItemView2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder2(itemBinding2)

            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(items[position].type){
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

    fun setData(data: List<Userdata>){
        items = data
        notifyDataSetChanged()
    }

}