package com.example.withmehome

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.withmehome.databinding.ActivityLoginBinding
import com.example.withmehome.databinding.ActivityMapsBinding
import com.kakao.sdk.auth.TokenManager.Companion.instance
import com.kakao.sdk.auth.TokenManager.Companion.tokenKey
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_nickname_set.*
import retrofit2.Call
import retrofit2.Response
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.security.auth.callback.Callback
import kotlin.math.log


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    //private lateinit var aToken: String
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        KakaoSdk.init(this, "818712b89ed47ae9edee2e90fe16dcdf")
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)


        // 로그인 정보 확인
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NicknameSetActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        Log.d("[카카오로그인]", "접근이 거부 됨(동의 취소)")
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        Log.d("[카카오로그인]", "유효하지 않은 앱")
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        Log.d("[카카오로그인]", "인증 수단이 유효하지 않아 인증할 수 없는 상태")
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        Log.d("[카카오로그인]", "요청 파라미터 오류")
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        Log.d("[카카오로그인]", "유효하지 않은 scope ID")
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        Log.d("[카카오로그인]", "설정이 올바르지 않음(android key hash)")
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        Log.d("[카카오로그인]", "서버 내부 에러")
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        Log.d("[카카오로그인]", "앱이 요청 권한이 없음")
                    }
                    else -> { // Unknown
                        Log.d("[카카오로그인]", "기타 에러")
                    }
                }
            } else if (token != null) {
                Toast.makeText(this, "로그인에 성공하였습니다. ${token.accessToken}", Toast.LENGTH_SHORT)
                    .show()
                //aToken = token.accessToken
                Log.d("token:",token.accessToken)
                retrofitLogin(token.accessToken)
                val intent = Intent(this, NicknameSetActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }
        // 로그인 버튼
        //val kakao_login_button = findViewById<ImageButton>(R.id.login_kakaoButton)
        login_kakaoButton.setOnClickListener {
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)

            }else{
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }

        }

    }

    private fun retrofitLogin(token: String){
        val service = RetrofitApi.loginService
        service.setLoginData(token)
            .enqueue(object : retrofit2.Callback<LoginData> {
                override fun onResponse(
                    call: Call<LoginData>,
                    response: Response<LoginData>
                ) {
                    if (response.isSuccessful){
                        val result: String? = response.body()?.data?.accessToken
                        Log.d("tokeeeeeen", response.body()?.data?.accessToken.toString())
                    }
                }
                override fun onFailure(call: Call<LoginData>, t: Throwable) {
                    Log.d("tag", t.message.toString())
                }

            }
            )

    }

}