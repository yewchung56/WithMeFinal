package com.example.withmehome

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewmessageBinding


class MRecyclerItemAdapter(var items: List<MUserdata>) : RecyclerView.Adapter<MRecyclerItemAdapter.ViewHolder>() {

    private lateinit var itemBinding: ItemViewmessageBinding

    inner class ViewHolder(private val itemBinding: ItemViewmessageBinding): RecyclerView.ViewHolder(itemBinding.root){
        private val context = itemBinding.root.context
        fun bind(data: MUserdata){
            itemBinding.name.text = data.name
            itemBinding.content.text = data.content
            itemBinding.date.text = data.date

            itemView.setOnClickListener{
                val intent = Intent(context, sharing_message::class.java)
                intent.run { context.startActivity(this) }
            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = ItemViewmessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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