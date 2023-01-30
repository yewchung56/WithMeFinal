package com.example.withmehome

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.withmehome.databinding.FragmentMeetmainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MeetmainFragment:Fragment() {

    private lateinit var binding: FragmentMeetmainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMeetmainBinding.inflate(inflater, container,false)
        initViewPager()
        return binding.root
    }

    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅
        val viewPager2Adatper = ViewPager2Adapter(activity)
        viewPager2Adatper.addFragment(NowFragment())
        viewPager2Adatper.addFragment(LastFragment())

        //Adapter 연결
        binding.pager.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "현재 모임"
                1 -> tab.text = "지난 모임"
            }
        }.attach()
    }
}