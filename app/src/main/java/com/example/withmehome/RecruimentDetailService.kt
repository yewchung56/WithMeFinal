package com.example.withmehome

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecruimentDetailService {
    @GET("/api/meets/{meetId}")
    fun getRecDetailData(@Query("meetId") meetId : Int) : Call<RecruitmentDetailResponse>
}