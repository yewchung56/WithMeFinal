package com.example.withmehome

import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.PATCH
import retrofit2.Response
import retrofit2.http.*

interface NicknameSetService {
    @PATCH("/api/members/nickname")
    fun getNickname(@Body nickname: String) : Call<NicknameSetResponse>

}