package com.example.withmehome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withmehome.databinding.FragmentExtraBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Response

class ExtraFragment:Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentExtraBinding
    private lateinit var adapter: RecyclerItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = ArrayList<Userdata>()
        binding = FragmentExtraBinding.inflate(inflater, container,false)
        adapter = RecyclerItemAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerViewextra.adapter = adapter
        binding!!.recyclerViewextra.layoutManager = LinearLayoutManager(activity)

        var extraFragment = layoutInflater.inflate(R.layout.fragment_extra,container, false)


        val btn = extraFragment.findViewById<Button>(R.id.buttonallextra)
        list.add(Userdata("미라클 모닝 8주 도전", "김써니", "2/15","5",multi_type6,"  기타"))
        btn.setOnClickListener{
                adapter.setData(list)
                RecruitListShow()
        }

        return binding.root

        val btn_event= extraFragment.findViewById<Button>(R.id.extra)
        btn_event.setOnClickListener{
            val intent = Intent(getActivity(), WriteRecruitmentActivity::class.java)
            startActivity(intent)
        }



    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
        setOnClickListener2()
    }
    private fun setOnClickListener(){
        val extraSequence = binding.extra.setOnClickListener(this)
    }
    private fun setOnClickListener2(){
        val extra = binding.buttonallextra.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.extra -> {
                    val intent = Intent(activity, WriteRecruitmentActivity::class.java)
                    startActivity(intent)
                }
                R.id.buttonallextra ->{
                    val list = ArrayList<Userdata>()
                    list.add(Userdata("모집글 제목", "사용자 이름", "00/00 00:00","3",multi_type2,"  기타"))
                    adapter.setData(list)
                    RecruitListShow()
                }
            }
        }
    }
    private fun RecruitListShow(){
        val service = RetrofitApi.recruitListService
        service.getRecruitListData("STUDY",true,"우리은행스터디")
            .enqueue(object: retrofit2.Callback<ListShowResponse> {
                override fun onResponse(
                    call: Call<ListShowResponse>,
                    response: Response<ListShowResponse>
                ) {
                    if (response.isSuccessful){
                        Log.d("tokeeeeeen", response.body()?.data.toString())
                    }
                }
                override fun onFailure(call: Call<ListShowResponse>, t: Throwable) {
                    Log.d("tag", t.message.toString())
                }

            }
            )

    }
}