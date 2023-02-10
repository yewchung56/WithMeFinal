package com.example.withmehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentReview1Binding

class Review1Fragment:Fragment() {
    private lateinit var binding: FragmentReview1Binding
    private lateinit var adapter: ReviewRecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReview1Binding.inflate(inflater, container,false)
        adapter = ReviewRecyclerItemAdapter(loadData())
        adapter.setHasStableIds(true)
        binding!!.recyclerViewreview1.adapter = adapter
        binding!!.recyclerViewreview1.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }
    fun loadData(): List<ReviewUserdata>{
        val list = mutableListOf<ReviewUserdata>()
        for(i in 0..4){
            val data = ReviewUserdata("사용자 이름","내용이 이곳에 표시됩니다.","스터디명","00월 00일")
            list.add(data)
        }
        return list
    }
}