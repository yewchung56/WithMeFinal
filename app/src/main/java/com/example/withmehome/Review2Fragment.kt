package com.example.withmehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentReview2Binding

class Review2Fragment:Fragment() {
    private lateinit var binding: FragmentReview2Binding
    private lateinit var adapter: ReviewRecyclerItemAdapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = mutableListOf<ReviewUserdata>()
        list.add(ReviewUserdata("하나둘","정말 열심히 하시는 게 눈에 보이시던 분...!! 너무 멋있으셨어요. ","하나은행 코테 준비","1월 8일"))
        list.add(ReviewUserdata("슬랑","수고 많으셨어요!! 너무 재밌었습니다!! 공부도 열심히 하시고 좋으신 분이였습니다!!","영어회화 스터디 하실 분","1월 7일"))
        binding = FragmentReview2Binding.inflate(inflater, container,false)
        adapter = ReviewRecyclerItemAdapter2(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewreview2.adapter = adapter
        binding!!.recyclerViewreview2.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }

}