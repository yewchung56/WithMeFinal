package com.example.withmehome


import NicknameSetResponse
import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.PATCH
import retrofit2.Response
import retrofit2.http.*

interface NicknameSetService {
    @Headers(
        "accept: application/json",
        "content-type: application/json")
    @PATCH("/api/members/nickname")
    fun getNickname(@Body nickname: String) : Call<NicknameSetResponse>
}