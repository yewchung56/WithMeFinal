package com.example.withmehome

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url
import java.net.URL

interface WriteRecruitmentService {
    data class Addresses (
        @SerializedName("sido") val sido : String?,
        @SerializedName("sgg") val sgg : String?
    )
    data class RecData (
        val addresses: Addresses,
        val meetCategory: String,
        val title: String,
        val link: String,
        val content: String,
        val minPeople: Int,
        val maxPeople: Int,
    )
    @POST("/api/meets")
    fun getWriteRecData(@Body recdata: RecData )
        /*@Body addresses: Addresses,
                        @Body meetCategory: String,
                        @Body title: String,
                        @Query ("link") link: String,
                        @Query ("content") content: String,
                        @Query ("minPeople") minPeople: Int,
                        @Query ("maxPeople") maxPeople: Int)*/
    : Call<WriteRecruitmentResponse>
    /*val list: MutableList<String>
        get() = ArrayList()*/
}