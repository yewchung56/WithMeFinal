package com.example.withmehome

import NicknameSetResponse
import retrofit2.Call
import retrofit2.http.*

interface NicknameSetService {

    @PATCH("/api/members/nickname")
    fun setNicknameData(@Body nickname : String) : Call<NicknameSetResponse>
}