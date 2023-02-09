package com.example.withmehome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import com.example.withmehome.databinding.ActivityNicknameSetBinding
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.activity_nickname_set.*
import java.util.regex.Pattern

class NicknameSetActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityNicknameSetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNicknameSetBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_nickname_set)

        // 가입완료 버튼 클릭 시 동네 인증 화면으로 이동
        btn_set_nickname_complete.setOnClickListener{
            startActivity(Intent(this@NicknameSetActivity, MapsActivity::class.java))
        }

        // 비밀번호 조건 정규식 : 2~10 숫자, 문자만
        val pwValidation = "^[A-Za-z0-9]{2,10}$"

        // 조건부 닉네임 설정
        viewBinding.edtSetNicknameWriteNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkPassword()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        val nickname = findViewById<TextView>(R.id.edt_set_nickname_write_nickname)
        UserApiClient.instance.me { user, error ->
            nickname.text = "${user?.kakaoAccount?.profile?.nickname}"
            Log.d("닉네임:","${user?.kakaoAccount?.profile?.nickname}")
        }
    }

    // 조건만족 여부에 따른 이벤트
    fun checkPassword():Boolean{
        val pw = viewBinding.edtSetNicknameWriteNickname.text.toString().trim()
        val pwCheck = Pattern.matches(viewBinding.edtSetNicknameWriteNickname.toString(), pw)
        if(pwCheck) {
            viewBinding.edtSetNicknameWriteNickname.setTextColor(R.color.black.toInt())
            return true
        } else {
            viewBinding.edtSetNicknameWriteNickname.setTextColor((R.color.red.toInt()))
            return false
        }
    }
}