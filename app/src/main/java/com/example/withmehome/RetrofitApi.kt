package com.example.withmehome

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitApi {
    private const val BASE_URL = "http://54.180.188.181:8080/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    // Builder 패턴을 통해 retrofit 객체 생성
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    // retrofit 인스턴스에 create 명령어를 사용해 만들어 준 인터페이스의 인스턴스 생성
    // 실제 사용 할 서비스(인스턴스)
    val nicknameDupService: NicknameDupService by lazy {
        retrofit.create(NicknameDupService::class.java)
    }
}
