package com.example.withmehome

import android.content.Intent
import android.graphics.ColorSpace.Model
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.withmehome.databinding.FragmentTotalBinding
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_total.*


class TotalFragment:Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentTotalBinding
    private lateinit var adapter: RecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = mutableListOf<Userdata>()
        val Activity = layoutInflater.inflate(R.layout.activity_recruitment_detail,container,false)
        val event = Activity.findViewById<Button>(R.id.recruit_end)
        list.add(Userdata("우리은행 면접 스터디 구함당", "곰도리", "2/15","3",multi_type1,"스터디"))
        list.add(Userdata("CS스터디 구해요", "포메예용", "2/15","5",multi_type2,"스터디"))
        list.add(Userdata("걷기 달리기 운동습관 모임", "머슬퀸S2", "2/15","5",multi_type3,"  운동"))
        list.add(Userdata("전시회 같이 가실분!", "마네모네", "2/15","5",multi_type4,"  취미"))
        list.add(Userdata("MZ세대들의 카페&맛집 탐방", "유후잉", "2/15","3",multi_type5,"  여행"))
        list.add(Userdata("미라클 모닝 8주 도전", "김써니", "2/15","5",multi_type6,"  기타"))
        event.setOnClickListener {
            list.add(Userdata("모집글 제목", "사용자 이름", "00/00 00:00","3",multi_type2,"  기타"))
            adapter.notifyDataSetChanged()
        }
        binding = FragmentTotalBinding.inflate(inflater, container,false)
        adapter = RecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewtotal.adapter = adapter
        binding!!.recyclerViewtotal.layoutManager = LinearLayoutManager(activity)

        return binding.root

        var WriteRecruitmentActivity = layoutInflater.inflate(R.layout.fragment_total,container, false)
        total.setOnClickListener {
            val intent = Intent(getActivity(), WriteRecruitmentActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }
    private fun setOnClickListener(){
        val totalSequence = binding.total.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.total -> {
                    val intent = Intent(activity, WriteRecruitmentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}



