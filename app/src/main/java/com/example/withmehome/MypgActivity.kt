package com.example.withmehome;

import android.app.Activity;
import android.content.ContentValues.TAG
import android.content.Intent
import android.location.Address
import android.location.Geocoder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.example.withmehome.databinding.ActivityMessageBinding
import com.example.withmehome.databinding.ActivityMypgBinding
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.activity_mypg.*
import kotlinx.android.synthetic.main.item_viewcho.view.*
import java.lang.System.load
import java.net.URI
import java.util.*

class MypgActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMypgBinding
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMypgBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


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


        //var prof = findViewById<ImageView>(R.id.img_user)
        //prof.setImageURI()="${user.kakaoAccount?.profile?.thumbnailImageUrl}"

        UserApiClient.instance.me { user, error ->
            var user_pic = findViewById<ImageView>(R.id.img_user)
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            }
            else if (user != null) {
                Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n회원번호: ${user.id}" +
                        "\n이메일: ${user.kakaoAccount?.email}" +
                        "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                        "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")

            }

             }

        btn_wishlist.setOnClickListener {
            startActivity(Intent(this, LikeActivity::class.java))
        }

        btn_logout.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Log.e(TAG, "로그아웃 실패. SDK에서 토큰 삭제됨", error)
                }
                else {
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                    Log.i(TAG, "로그아웃 성공. SDK에서 토큰 삭제됨")
                }
            }
            System.exit(0)
        }

        btn_show_profile.setOnClickListener {
                startActivity(Intent(this@MypgActivity,ProfileActivity::class.java))
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
