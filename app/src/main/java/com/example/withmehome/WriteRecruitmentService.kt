package com.example.withmehome

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface WriteRecruitmentService {
    @POST("/api/meets")
    fun getWriteRecData(@Query("sido") sido : String,
                        @Query("sgg") sgg : String,
                        @Query("meetCategory") meetCategory: String,
                        @Query("title") title: String,
                        @Query("content") content: String,
                        @Query("minPeople") minPeople: Int,
                        @Query("maxPeople") maxPeople: Int) : Call<WriteRecruitmentResponse>
}