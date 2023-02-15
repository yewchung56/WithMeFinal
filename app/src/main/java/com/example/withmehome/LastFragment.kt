package com.example.withmehome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentLastBinding

class LastFragment:Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentLastBinding
    private lateinit var adapter: meetRecyclerItemAdapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val list = mutableListOf<meetUserdata2>()
        list.add(meetUserdata2("전시회 같이 가실분!", "마네모네", "23.01.20 ~ 23.01.30","5" , multi_type4, "취미"))
        list.add(meetUserdata2("MZ세대들의 카페&맛집 탐방", "유후잉", "23.01.20 ~ 23.01.30", "5", multi_type5,"여행"))
        list.add(meetUserdata2("미라클 모닝 8주 도전", "김써니", "23.01.20 ~ 23.01.30", "5", multi_type6,"  기타"))
        binding = FragmentLastBinding.inflate(inflater, container,false)
        adapter = meetRecyclerItemAdapter2(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewlast.adapter = adapter
        binding!!.recyclerViewlast.layoutManager = LinearLayoutManager(activity)

        return binding.root
        var WriteRecruitmentActivity = layoutInflater.inflate(R.layout.fragment_last,container, false)
        val btn_event= WriteRecruitmentActivity.findViewById<Button>(R.id.last)
        btn_event.setOnClickListener{
            val intent = Intent(getActivity(), WriteRecruitmentActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }
    private fun setOnClickListener(){
        val lastSequence = binding.last.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.last -> {
                    val intent = Intent(activity, WriteRecruitmentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}