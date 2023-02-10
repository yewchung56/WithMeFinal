package com.example.withmehome

import android.telecom.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @FormUrlEncoded
    @GET("/api/meets")
    fun getUser(title: String?,
                startDate: String?,
                nickname: String?,
                likeCount: Int?,
                meetStatus: String?,
                meetCategory: String?
    ):retrofit2.Call<DataResponse>

    @GET("{page}")
    fun getUserPage(@Path("page") page: String):retrofit2.Call<DataResponse>
}