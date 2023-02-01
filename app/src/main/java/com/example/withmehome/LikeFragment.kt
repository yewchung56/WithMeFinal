package com.example.withmehome

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.FragmentLikeBinding

class LikeFragment:Fragment() {
    private lateinit var binding: FragmentLikeBinding
    private lateinit var adapter: LikeRecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val list = mutableListOf<LUserdata>()
        list.add(LUserdata("모집글 제목", "사용자 이름", "00/00 00:00", "3"))
        list.add(LUserdata("모집글 제목", "사용자 이름", "00/00 00:00", "3"))
        list.add(LUserdata("모집글 제목", "사용자 이름", "00/00 00:00", "3"))
        binding = FragmentLikeBinding.inflate(inflater, container,false)
        adapter = LikeRecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewlike.adapter = adapter
        binding!!.recyclerViewlike.layoutManager = LinearLayoutManager(activity)


        val itemSwipe = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                showDialog(viewHolder)
            }
        }
        val swap = ItemTouchHelper(itemSwipe)
        swap.attachToRecyclerView(binding.recyclerViewlike)

        return binding.root
    }
    private fun showDialog(viewHolder: RecyclerView.ViewHolder) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Delete Item")
        builder.setMessage("삭제하시겠습니까?")
        builder.setPositiveButton("네") { dialog, which ->
            val position = viewHolder.adapterPosition
            adapter.notifyItemRemoved(position)

        }
        builder.setNegativeButton("아니요") { dialog, which ->
            val position = viewHolder.adapterPosition
            adapter.notifyItemChanged(position)
        }
        builder.show()
    }

}