
package com.example.withmehome

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentNowBinding

class NowFragment:Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentNowBinding
    private lateinit var adapter: meetRecyclerItemAdapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = mutableListOf<meetUserdata2>()
        list.add(meetUserdata2("우리은행 면접 스터디 구함당", "곰도리", "23.02.20 ~ 23.03.30", "5", multi_type1,"스터디"))
        list.add(meetUserdata2("걷기 달리기 운동습관 모임", "머슬퀸S2", "23.02.20 ~ 23.03.30", "6", multi_type2,"  운동"))
        list.add(meetUserdata2("CS스터디 구해요", "포메예용", "23.02.20 ~ 23.03.30", "6", multi_type3, "스터디"))
        binding = FragmentNowBinding.inflate(inflater, container,false)
        adapter = meetRecyclerItemAdapter2(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewnow.adapter = adapter
        binding!!.recyclerViewnow.layoutManager = LinearLayoutManager(activity)

        return binding.root

        var WriteRecruitmentActivity = layoutInflater.inflate(R.layout.fragment_now,container, false)
        val btn_event= WriteRecruitmentActivity.findViewById<Button>(R.id.now)
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
        val nowSequence = binding.now.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.now -> {
                    val intent = Intent(activity, WriteRecruitmentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}