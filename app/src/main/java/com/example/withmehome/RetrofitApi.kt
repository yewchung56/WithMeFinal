package com.example.withmehome

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.io.IOException

object RetrofitApi {
    private const val BASE_URL = "http://54.180.188.181:8080/"

    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain) : Response = with(chain) {
            /*val addresses : ArrayList<String>*/
            val token = "Bearer " +
                    "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiJ5ZXdjaHVuZzU2QG5hdmVyLmNvbSIsImlhdCI6MTY3NjM3Nzk2MCwiZXhwIjoxNjc2OTgyNzYwfQ.azTwqcfLv0mtnexeDIFBuWHFv5WroVNqS5I7EcIr_wQ"
            val newRequest = request().newBuilder()
                .addHeader("Authorization",token)
                .build()
            proceed(newRequest)
        }
    }
    /*HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }*/
    val okHttpClient = OkHttpClient.Builder().addInterceptor(AppInterceptor())
            .build()
    val jsonObject = JSONObject()
    val requestBody = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), jsonObject.toString())
    // Builder 패턴을 통해 retrofit 객체 생성
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient )
            .baseUrl(BASE_URL)
            .build()
    }
    // retrofit 인스턴스에 create 명령어를 사용해 만들어 준 인터페이스의 인스턴스 생성
    // 실제 사용 할 서비스(인스턴스)
    val nicknameDupService: NicknameDupService by lazy {
        retrofit.create(NicknameDupService::class.java)
    }
    /*val writeRecruitmentService: MeetFormRequest by lazy {
        retrofit.create(MeetFormRequest::class.java)
    }*/
    val loginService: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }
    val recruitListService: RecruitListService by lazy {
        retrofit.create(RecruitListService::class.java)
    }
    val nicknameSetService: NicknameSetService by lazy {
        retrofit.create(NicknameSetService::class.java)
    }
    val recruitmentDetailService : RecruimentDetailService by lazy {
        retrofit.create(RecruimentDetailService::class.java)
    }
}
//VMbYn1x2CQxthH8anTbZ1nfh3FKYHk-LaioerUbcCiolDwAAAYZP6bCf
