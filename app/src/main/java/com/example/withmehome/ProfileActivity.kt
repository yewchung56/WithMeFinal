package com.example.withmehome

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.withmehome.databinding.ActivityMypgBinding
import com.example.withmehome.databinding.ActivityProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    var isStarted = false
    var progressStatus = 0
    var handler: Handler? = null
    var secondaryHandler: Handler? = Handler()
    var primaryProgressStatus = 0
    var secondaryProgressStatus = 0

    private lateinit var viewBinding: ActivityProfileBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Rev_RecyclerView
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        recyclerView = findViewById(R.id.horizontal_recy)
        adapter = Rev_RecyclerView()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        handler = Handler(Handler.Callback {
            if (isStarted) {
                progressStatus++
            }
            progressBar_regi.progress = progressStatus
            textViewHorizontalProgress_regi.text = "${progressStatus}%"
            handler?.sendEmptyMessageDelayed(0, 100)

            true
        })

        handler?.sendEmptyMessage(0)
        icon1.setOnClickListener {
            primaryProgressStatus = 0
            secondaryProgressStatus = 0

            Thread(Runnable {
                while (primaryProgressStatus < 100) {
                    primaryProgressStatus += 1

                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }).start()
        }

        bottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigationView?.setSelectedItemId(R.id.mypg)
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

    }

}
