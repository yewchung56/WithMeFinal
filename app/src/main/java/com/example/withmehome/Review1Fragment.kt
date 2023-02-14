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

        val list = mutableListOf<ReviewUserdata>()
        list.add(ReviewUserdata("하나둘","똑똑하시고 성격도 너무 좋으신 분... 궁금한 것 많이 여쭤봤는데 항상 친절하게 잘 설명해주셨어요","하나은행 코테 준비","1월 8일"))
        list.add(ReviewUserdata("슬랑","수고 많으셨어요!! 영어랑 친해지고 유익한 시간이었어요.","영어회화 스터디 하실 분","1월 7일"))
        binding = FragmentReview1Binding.inflate(inflater, container,false)
        adapter = ReviewRecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewreview1.adapter = adapter
        binding!!.recyclerViewreview1.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }
}