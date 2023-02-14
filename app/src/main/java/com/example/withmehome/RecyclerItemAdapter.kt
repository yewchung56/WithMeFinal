package com.example.withmehome

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.withmehome.databinding.ActivityWriteRecruitmentBinding
import com.example.withmehome.databinding.ItemView2Binding
import com.example.withmehome.databinding.ItemView3Binding
import com.example.withmehome.databinding.ItemView4Binding
import com.example.withmehome.databinding.ItemView5Binding
import com.example.withmehome.databinding.ItemView6Binding
import com.example.withmehome.databinding.ItemViewBinding
import kotlinx.android.synthetic.main.item_view.view.*


class RecyclerItemAdapter(var items: List<Userdata>) : RecyclerView.Adapter<ViewHolder>() {

    private lateinit var itemBinding: ItemViewBinding
    private lateinit var itemBinding2: ItemView2Binding
    private lateinit var itemBinding3: ItemView3Binding
    private lateinit var itemBinding4: ItemView4Binding
    private lateinit var itemBinding5: ItemView5Binding
    private lateinit var itemBinding6: ItemView6Binding

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
    inner class MultiViewHolder3(private val itemBinding3: ItemView3Binding): ViewHolder(itemBinding3.root){
        private val context3 = itemBinding3.root.context
        fun bind(data: Userdata){
            itemBinding3.title.text = data.title
            itemBinding3.name.text = data.name
            itemBinding3.date.text = data.date
            itemBinding3.like.text = data.like
            itemBinding3.category.text = data.category

            itemView.setOnClickListener{
                val intent = Intent(context3, RecruitmentDetailActivity::class.java)
                intent.run { context3.startActivity(this) }
            }
        }
    }
    inner class MultiViewHolder4(private val itemBinding4: ItemView4Binding): ViewHolder(itemBinding4.root){
        private val context4 = itemBinding4.root.context
        fun bind(data: Userdata){
            itemBinding4.title.text = data.title
            itemBinding4.name.text = data.name
            itemBinding4.date.text = data.date
            itemBinding4.like.text = data.like
            itemBinding4.category.text = data.category

            itemView.setOnClickListener{
                val intent = Intent(context4, RecruitmentDetailActivity::class.java)
                intent.run { context4.startActivity(this) }
            }
        }
    }
    inner class MultiViewHolder5(private val itemBinding5: ItemView5Binding): ViewHolder(itemBinding5.root){
        private val context5 = itemBinding5.root.context
        fun bind(data: Userdata){
            itemBinding5.title.text = data.title
            itemBinding5.name.text = data.name
            itemBinding5.date.text = data.date
            itemBinding5.like.text = data.like
            itemBinding5.category.text = data.category

            itemView.setOnClickListener{
                val intent = Intent(context5, RecruitmentDetailActivity::class.java)
                intent.run { context5.startActivity(this) }
            }
        }
    }
    inner class MultiViewHolder6(private val itemBinding6: ItemView6Binding): ViewHolder(itemBinding6.root){
        private val context6 = itemBinding6.root.context
        fun bind(data: Userdata){
            itemBinding6.title.text = data.title
            itemBinding6.name.text = data.name
            itemBinding6.date.text = data.date
            itemBinding6.like.text = data.like
            itemBinding6.category.text = data.category

            itemView.setOnClickListener{
                val intent = Intent(context6, RecruitmentDetailActivity::class.java)
                intent.run { context6.startActivity(this) }
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
            multi_type2 -> {
                itemBinding2 = ItemView2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder2(itemBinding2)

            }
            multi_type3 -> {
                itemBinding3 = ItemView3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder3(itemBinding3)

            }
            multi_type4 -> {
                itemBinding4 = ItemView4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder4(itemBinding4)

            }
            multi_type5 -> {
                itemBinding5 = ItemView5Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder5(itemBinding5)

            }
            else -> {
                itemBinding6 = ItemView6Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder6(itemBinding6)

            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(items[position].type){
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(items[position])
                holder.setIsRecyclable(false)
            }
            multi_type2 -> {
                (holder as MultiViewHolder2).bind(items[position])
                holder.setIsRecyclable(false)
            }
            multi_type3 -> {
                (holder as MultiViewHolder3).bind(items[position])
                holder.setIsRecyclable(false)
            }
            multi_type4 -> { (holder as MultiViewHolder4).bind(items[position])
            holder.setIsRecyclable(false)
            }
            multi_type5 -> {
                (holder as MultiViewHolder5).bind(items[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as MultiViewHolder6).bind(items[position])
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
        val list = mutableListOf<Userdata>()
        list.add(Userdata("모집글 제목", "사용자 이름", "00/00 00:00","3",multi_type2,"  기타"))
        items = data
        notifyDataSetChanged()
    }

}