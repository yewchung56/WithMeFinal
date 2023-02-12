package com.example.withmehome

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NicknameDupService {
    @GET("/api/members/check")
    fun getNicknameData(@Query("nickname") nickname : String) : Call<NicknameDupResponse>
}