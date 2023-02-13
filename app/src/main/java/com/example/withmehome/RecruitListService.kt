package com.example.withmehome

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecruitListService {
    @GET("/api/meets")
    fun getRecruitListData(@Query("category") category: String,
                        @Query("isLocal") isLocal: Boolean,
                        @Query("title") title: String,
    ) : Call<ListShowResponse>
}