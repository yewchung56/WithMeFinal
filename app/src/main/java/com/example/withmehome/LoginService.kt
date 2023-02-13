package com.example.withmehome


import retrofit2.Call
import retrofit2.http.*

interface LoginService {
    @POST("/api/auth/login")
    fun setLoginData(@Body KakaoAccessToken : String) : Call<LoginData>
}
