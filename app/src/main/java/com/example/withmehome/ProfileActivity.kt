package com.example.withmehome

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.withmehome.databinding.ActivityMypgBinding
import com.example.withmehome.databinding.ActivityProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kakao.sdk.user.UserApiClient
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

        //글라이더 로드
        var nickname = findViewById<TextView>(R.id.txt_user_name)
        var email = findViewById<TextView>(R.id.txt_user_address)
        val imageView = findViewById<ImageView>(R.id.img_user)
        val defaultImage = R.drawable.ic_recruitment_detail_photo



        UserApiClient.instance.me { user, error ->
            nickname.text = "${user?.kakaoAccount?.profile?.nickname}"
            email.text = "${user?.kakaoAccount?.email}"
            Log.d("닉네임:","${user?.kakaoAccount?.email}")
            var url = "${user?.kakaoAccount?.profile?.thumbnailImageUrl}"

            Glide.with(this)
                .load(url) // 불러올 이미지 url
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .circleCrop() // 동그랗게 자르기
                .into(imageView) // 이미지를 넣을 뷰
        }

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
