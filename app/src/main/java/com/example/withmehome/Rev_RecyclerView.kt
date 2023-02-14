package com.example.withmehome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemProfileReviewBinding
import com.example.withmehome.databinding.ItemViewlikeBinding

class Rev_RecyclerView(var items: List<ProfileRevData>): RecyclerView.Adapter<Rev_RecyclerView.ViewHolder>() {
    private lateinit var itemBinding: ItemProfileReviewBinding

    inner class ViewHolder(private val itemBinding: ItemProfileReviewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: ProfileRevData) {
            itemBinding.txtPrName.text = data.name
            itemBinding.txtPrContent.text = data.content
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
//        return MyViewHolder(view)
        itemBinding = ItemProfileReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setPrData(data: List<ProfileRevData>) {
        items = data
        notifyDataSetChanged()
    }


//    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//
//    }

}