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
        binding = FragmentLastBinding.inflate(inflater, container,false)
        adapter = meetRecyclerItemAdapter2(loadData())
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
    fun loadData(): List<meetUserdata>{
        val list = mutableListOf<meetUserdata>()
        for(i in 0..100){
            val data = meetUserdata("모집글 제목", "사용자 이름", "00.00.00 ~ 00.00.00", "3")
            list.add(data)
        }
        return list
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