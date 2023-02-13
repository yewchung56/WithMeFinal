package com.example.withmehome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentHobbyallBinding

class HobbyallFragment:Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHobbyallBinding
    private lateinit var adapter: RecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = mutableListOf<Userdata>()
        val Activity = layoutInflater.inflate(R.layout.activity_recruitment_detail,container,false)
        val event = Activity.findViewById<Button>(R.id.recruit_end)
        event.setOnClickListener {
            list.add(Userdata("모집글 제목", "사용자 이름", "00/00 00:00","3",multi_type2,"  기타"))
            adapter.notifyDataSetChanged()
        }
        binding = FragmentHobbyallBinding.inflate(inflater, container,false)
        adapter = RecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewhobbyall.adapter = adapter
        binding!!.recyclerViewhobbyall.layoutManager = LinearLayoutManager(activity)

        return binding.root

        val WriteRecruitmentActivity = layoutInflater.inflate(R.layout.fragment_hobbyall,container, false)
        val btn_event= WriteRecruitmentActivity.findViewById<Button>(R.id.hobbyall)
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
        val hobbyallSequence = binding.hobbyall.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.hobbyall -> {
                    val intent = Intent(activity, WriteRecruitmentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}