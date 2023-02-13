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
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern
import javax.security.auth.callback.Callback

class NicknameSetActivity : AppCompatActivity() {
    private val binding: ActivityNicknameSetBinding by lazy {
        ActivityNicknameSetBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname_set)

        /*val nickname = findViewById<TextView>(R.id.edt_set_nickname_write_nickname)
        UserApiClient.instance.me { user, error ->
            nickname.text = "${user?.kakaoAccount?.profile?.nickname}"
            Log.d("닉네임:", "${user?.kakaoAccount?.profile?.nickname}")
        }*/

        // 조건부 닉네임 설정
        edt_set_nickname_write_nickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkPassword(edt_set_nickname_write_nickname.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        // 액티비티에서 retrofit 사용 시작
        btn_set_nickname_check_dup.setOnClickListener {
            retrofitCheckDup()
        }
        // 가입완료 버튼 클릭 시 동네 인증 화면으로 이동
        btn_set_nickname_complete.setOnClickListener {
            retrofitSetNick()
            startActivity(Intent(this@NicknameSetActivity, MapsActivity::class.java))
        }
    }
    // 조건만족 여부에 따른 이벤트
    private fun checkPassword(password: String): Boolean {
        // 비밀번호 조건 정규식 : 2~10 숫자, 문자만
        val pwValidation = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{2,10}$"

        val pw = edt_set_nickname_write_nickname.text.toString().trim()

        val pattern = Pattern.compile(pwValidation)
        val matcher = pattern.matcher(pw)

        if (matcher.find()) {
            txt_set_nickname_alert.setTextColor(R.color.black.toInt())
            txt_set_nickname_alert.text = " "
            return true
        } else {
            txt_set_nickname_alert.setTextColor((R.color.red.toInt()))
            txt_set_nickname_alert.text = "2~10자 숫자, 문자만 가능. 특수기호 불가"
            return false
        }
    }

    // 닉네임 중복 확인
    private fun retrofitCheckDup() {
        val service = RetrofitApi.nicknameDupService

        service.getNicknameData(edt_set_nickname_write_nickname.toString())
            .enqueue(object : retrofit2.Callback<NicknameDupResponse> {
                override fun onResponse(
                    call: Call<NicknameDupResponse>,
                    response: Response<NicknameDupResponse>
                ) {
                    if (response.isSuccessful) {
                        val result : Boolean? = response.body()?.data?.duplicated
                        Log.d("Tag", response.body()?.data?.duplicated.toString())
                        if (result == true) {
                            txt_set_nickname_alert.setTextColor(R.color.blue.toInt())
                            txt_set_nickname_alert.text = "사용 가능한 닉네임입니다."
                            btn_set_nickname_complete.isClickable = true
                        } else {
                            txt_set_nickname_alert.setTextColor(R.color.red.toInt())
                            txt_set_nickname_alert.text = "이미 사용중인 닉네임입니다."
                        }
                    }
                }

                override fun onFailure(call: Call<NicknameDupResponse>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

    private fun retrofitSetNick() {
        val service = RetrofitApi.nicknameSetService

        serv
    }
}