package com.example.withmehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentLastBinding

class LastFragment:Fragment() {

    private lateinit var binding: FragmentLastBinding
    private lateinit var adapter: meetRecyclerItemAdapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLastBinding.inflate(inflater, container,false)
        adapter = meetRecyclerItemAdapter2(loadData())
        adapter.setHasStableIds(true)
        binding!!.recyclerViewlast.adapter = adapter
        binding!!.recyclerViewlast.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }
    fun loadData(): List<meetUserdata>{
        val list = mutableListOf<meetUserdata>()
        for(i in 0..100){
            val data = meetUserdata("모집글 제목", "사용자 이름", "00.00.00 ~ 00.00.00", "3")
            list.add(data)
        }
        return list
    }
}