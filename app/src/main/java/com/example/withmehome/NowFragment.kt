
package com.example.withmehome

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentNowBinding

class NowFragment:Fragment() {
    private lateinit var binding: FragmentNowBinding
    private lateinit var adapter: meetRecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNowBinding.inflate(inflater, container,false)
        adapter = meetRecyclerItemAdapter(loadData())
        adapter.setHasStableIds(true)
        binding!!.recyclerViewnow.adapter = adapter
        binding!!.recyclerViewnow.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }
    fun loadData(): List<meetUserdata>{
        val list = mutableListOf<meetUserdata>()
        for(i in 0..100){
            val data = meetUserdata("모집글 제목", "사용자 이름", "00.00.00 ~ 00.00.00", "00")
            list.add(data)
        }
        return list
    }
}