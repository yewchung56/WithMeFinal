package com.example.withmehome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.withmehome.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.common.util.Utility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigationView?.setSelectedItemId(R.id.home)
        bottomNavigationView?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.history -> {
                    startActivity(Intent(applicationContext, MeetmainActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.home -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.note -> {
                    startActivity(Intent(applicationContext, MessageActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mypg -> {
                    startActivity(Intent(applicationContext, MypgActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

        initViewPager()
    }
    private fun initViewPager(){
        //ViewPager2 Adapter ??????
        var viewPager2Adatper = ViewPager2Adapter(this)
        viewPager2Adatper.addFragment(TotalFragment())
        viewPager2Adatper.addFragment(StudyFragment())
        viewPager2Adatper.addFragment(SportFragment())
        viewPager2Adatper.addFragment(HobbyFragment())
        viewPager2Adatper.addFragment(TravelFragment())
        viewPager2Adatper.addFragment(ExtraFragment())

        //Adapter ??????
        binding.pager.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout ??????
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "??????"
                1 -> tab.text = "?????????"
                2 -> tab.text = "??????"
                3 -> tab.text = "??????"
                4 -> tab.text = "??????"
                5 -> tab.text = "??????"
            }
        }.attach()
    }
}
