package com.example.withmehome


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @POST("/api/auth/login")
    fun setLoginData(@Query("KakaoAccessToken") kakaoAccessToken : String) : Call<LoginData>
}
