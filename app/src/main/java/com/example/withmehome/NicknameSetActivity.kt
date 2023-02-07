package com.example.withmehome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.withmehome.databinding.ActivityNicknameSetBinding
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

        // 가입완료 버튼 클릭 시 동네 인증 화면으로 이동
        btn_set_nickname_complete.setOnClickListener{
            startActivity(Intent(this@NicknameSetActivity, MapsActivity::class.java))
        }

        // 비밀번호 조건 정규식 : 2~10 숫자, 문자만
        val pwValidation = "^[A-Za-z0-9]{2,10}$"

        // 조건부 닉네임 설정
        binding.edtSetNicknameWriteNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkPassword()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        // 액티비티에서 retrofit 사용 시작
        binding.btnSetNicknameCheckDup.setOnClickListener {
            retrofitCheckDup()
        }
    }

    // 조건만족 여부에 따른 이벤트
    fun checkPassword():Boolean{
        val pw = binding.edtSetNicknameWriteNickname.text.toString().trim()
        val pwCheck = Pattern.matches(binding.edtSetNicknameWriteNickname.toString(), pw)
        if(pwCheck) {
            binding.edtSetNicknameWriteNickname.setTextColor(R.color.black.toInt())
            return true
        } else {
            binding.edtSetNicknameWriteNickname.setTextColor((R.color.red.toInt()))
            binding.txtNicknameSetExp.text = "2~10자 숫자, 문자만 가능. 특수기호 불가"
            return false
        }
    }

    // 닉네임 중복 확인
    private fun retrofitCheckDup() {
        val service = RetrofitApi.nicknameDupService

        service.getNicknameData(binding.edtSetNicknameWriteNickname.toString())
            .enqueue(object : retrofit2.Callback<NicknameDupResponse> {
                override fun onResponse(
                    call : Call<NicknameDupResponse>,
                    response: Response<NicknameDupResponse>
                ) {
                    if(response.isSuccessful) {
                        val result = response.body()?.data?.duplicated
                        if (result == true) {
                            binding.txtNicknameSetExp.setTextColor(R.color.blue.toInt())
                            binding.txtNicknameSetExp.text = "사용 가능한 닉네임입니다."
                            binding.btnSetNicknameComplete.isClickable
                        }
                        else {
                            binding.txtNicknameSetExp.setTextColor(R.color.red.toInt())
                            binding.txtNicknameSetExp.text = "이미 사용중인 닉네임입니다."
                        }
                    }
                }

                override fun onFailure(call: Call<NicknameDupResponse>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }
}