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
import com.example.withmehome.databinding.FragmentMessageBinding

class MessageFragment:Fragment() {
    private lateinit var binding: FragmentMessageBinding
    private lateinit var adapter: MRecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 데이터
        val list = mutableListOf<MUserdata>()

        list.add(MUserdata("작성자 이름", "쪽지 내용이 여기에 표시됩니다.", "0000.00.00"))
        binding = FragmentMessageBinding.inflate(inflater, container, false)

        val adapter = MRecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewmessage.adapter = adapter
        binding!!.recyclerViewmessage.layoutManager = LinearLayoutManager(activity)


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
        swap.attachToRecyclerView(binding.recyclerViewmessage)

        return binding.root


    }

    private fun showDialog(viewHolder: RecyclerView.ViewHolder) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Delete Item")
        builder.setMessage("삭제하시겠습니까?")
        builder.setPositiveButton("네") { dialog, which ->
            val position = viewHolder.adapterPosition
            adapter.notifyItemChanged(position)

        }
        builder.setNegativeButton("아니요") { dialog, which ->
            val position = viewHolder.adapterPosition
            adapter.notifyItemChanged(position)
        }
        builder.show()
    }
}