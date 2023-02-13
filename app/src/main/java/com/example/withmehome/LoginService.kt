package com.example.withmehome

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoginService {
    @GET("/api/auth/login")
    fun getLoginData(
        @Query("User") user : String) : Call<LoginUserResponse>

}