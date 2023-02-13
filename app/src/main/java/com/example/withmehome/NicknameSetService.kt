package com.example.withmehome

import android.telecom.Call
import retrofit2.http.PATCH
import retrofit2.http.Query

interface NicknameSetService {
    @PATCH("/api/members/nickname")
    fun setNickname(@Query("nickname") nickname : String): retrofit2.Call<NicknameSetResponse>
}