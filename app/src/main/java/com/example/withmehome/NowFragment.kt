
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
    private lateinit var adapter: meetRecyclerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = mutableListOf<meetUserdata>()
        list.add(meetUserdata("모집글 제목", "사용자 이름", "00.00.00 ~ 00.00.00", "00"))
        list.add(meetUserdata("모집글 제목", "사용자 이름", "00.00.00 ~ 00.00.00", "00"))
        list.add(meetUserdata("모집글 제목", "사용자 이름", "00.00.00 ~ 00.00.00", "00"))
        binding = FragmentNowBinding.inflate(inflater, container,false)
        adapter = meetRecyclerItemAdapter(list)
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