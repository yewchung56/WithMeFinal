package com.example.withmehome

import android.os.Bundle
import android.renderscript.Matrix4f
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentMessageBinding

class MessageFragment:Fragment() {
    private lateinit var binding: FragmentMessageBinding
    private lateinit var adapter: MRecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater, container,false)
        val list = mutableListOf<MUserdata>()
        list.add(MUserdata("작성자 이름", "쪽지 내용이 여기에 표시됩니다.", "0000.00.00"))
        list.add(MUserdata("작성자 이름", "쪽지 내용이 여기에 표시됩니다.", "0000.00.00"))
        list.add(MUserdata("작성자 이름", "쪽지 내용이 여기에 표시됩니다.", "0000.00.00"))
        val adapter = MRecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewmessage.adapter = adapter
        binding!!.recyclerViewmessage.layoutManager = LinearLayoutManager(activity)


        return binding.root
    }

}