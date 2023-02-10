package com.example.withmehome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentExtraallBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExtraallFragment:Fragment(), View.OnClickListener{
    private lateinit var binding: FragmentExtraallBinding
    private lateinit var adapter: RecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = mutableListOf<Userdata>()
        list.add(Userdata("모집글 제목", "사용자 이름", "00/00 00:00","3",multi_type2,"  기타"))
        list.add(Userdata("모집글 제목", "사용자 이름", "00/00 00:00","3",multi_type1,"  기타"))
        list.add(Userdata("모집글 제목", "사용자 이름", "00/00 00:00","3",multi_type1, "  기타"))

        binding = FragmentExtraallBinding.inflate(inflater, container,false)
        adapter = RecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewextraall.adapter = adapter
        binding!!.recyclerViewextraall.layoutManager = LinearLayoutManager(activity)

        return binding.root
        val WriteRecruitmentActivity = inflater.inflate(R.layout.fragment_extraall,container, false)
        val btn_event= WriteRecruitmentActivity.findViewById<Button>(R.id.extraall)
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
        val extraallSequence = binding.extraall.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.extra -> {
                    val intent = Intent(activity, WriteRecruitmentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
