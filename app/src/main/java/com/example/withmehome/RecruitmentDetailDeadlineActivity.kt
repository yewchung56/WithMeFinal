package com.example.withmehome

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.withmehome.databinding.ActivityRecruitmentDetailDeadlineBinding
import com.kakao.sdk.user.UserApiClient

class RecruitmentDetailDeadlineActivity: AppCompatActivity()  {
    private lateinit var binding: ActivityRecruitmentDetailDeadlineBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recruitment_detail_deadline)

        var nickname = findViewById<TextView>(R.id.txt_user_name)
        //var email = findViewById<TextView>(R.id.txt_user_address)
        val imageView = findViewById<ImageView>(R.id.recruitment_detail_userphoto)
        val defaultImage = R.drawable.ic_recruitment_detail_photo

        UserApiClient.instance.me { user, error ->
            nickname.text = "${user?.kakaoAccount?.profile?.nickname}"
            //email.text = "${user?.kakaoAccount?.email}"
            Log.d("닉네임:","${user?.kakaoAccount?.profile?.nickname}")
            var url = "${user?.kakaoAccount?.profile?.thumbnailImageUrl}"

            Glide.with(this)
                .load(url) // 불러올 이미지 url
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .circleCrop() // 동그랗게 자르기
                .into(imageView) // 이미지를 넣을 뷰
        }


        /*val toolbar = findViewById<Toolbar>(R.id.sharing_message_toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar!!
        actionbar.setDisplayShowTitleEnabled(false)
        actionbar.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_sharing_message_back)*/

        binding= ActivityRecruitmentDetailDeadlineBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }*/
}