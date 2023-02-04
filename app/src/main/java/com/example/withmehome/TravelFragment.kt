package com.example.withmehome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentTravelBinding
import kotlinx.android.synthetic.main.fragment_travel.*
import kotlinx.android.synthetic.main.fragment_travelall.*

class TravelFragment:Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentTravelBinding
    private lateinit var adapter: RecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTravelBinding.inflate(inflater, container,false)
        adapter = RecyclerItemAdapter(loadData())
        adapter.setHasStableIds(true)
        binding!!.recyclerViewtravel.adapter = adapter
        binding!!.recyclerViewtravel.layoutManager = LinearLayoutManager(activity)

        return binding.root
        var WriteRecruitmentActivity = layoutInflater.inflate(R.layout.fragment_travel,container, false)
        travel.setOnClickListener {
            val intent = Intent(getActivity(), WriteRecruitmentActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }
    fun loadData(): List<Userdata>{
        val list = mutableListOf<Userdata>()
        for(i in 0..100){
            val data = Userdata("모집글 제목", "사용자 이름", "00/00 00:00", "3")
            list.add(data)
        }
        return list
    }
    private fun setOnClickListener(){
        val travelSequence = binding.travel.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.travel -> {
                    val intent = Intent(activity, WriteRecruitmentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}