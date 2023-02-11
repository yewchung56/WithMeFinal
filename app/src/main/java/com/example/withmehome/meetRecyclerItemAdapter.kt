package com.example.withmehome

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ItemViewmeetBinding


class meetRecyclerItemAdapter(var items: List<meetUserdata>) : RecyclerView.Adapter<meetRecyclerItemAdapter.ViewHolder>() {

    private lateinit var itemBinding: ItemViewmeetBinding

    inner class ViewHolder(private val itemBinding: ItemViewmeetBinding): RecyclerView.ViewHolder(itemBinding.root){
        private val context = itemBinding.root.context
        fun bind(data: meetUserdata){
            itemBinding.title.text = data.title
            itemBinding.name.text = data.name
            itemBinding.date.text = data.date
            itemBinding.like.text= data.like
            itemView.setOnClickListener {
                val intent = Intent(context, RecruitmentDetailDeadlineActivity::class.java)
                intent.run{context.startActivity(this)}
            }
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