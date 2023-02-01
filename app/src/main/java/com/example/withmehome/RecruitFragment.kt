package com.example.withmehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentRecruitBinding

class RecruitFragment:Fragment() {
    private lateinit var binding: FragmentRecruitBinding
    private lateinit var adapter: choRecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecruitBinding.inflate(inflater, container,false)
        adapter = choRecyclerItemAdapter(loadData())
        adapter.setHasStableIds(true)
        binding!!.recyclerViewrecruit.adapter = adapter
        binding!!.recyclerViewrecruit.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }
    fun loadData(): List<choUserdata>{
        val list = mutableListOf<choUserdata>()
        for(i in 0..100){
            val data = choUserdata("사용자 이름", "지역 이름")
            list.add(data)
        }
        return list
    }
}