package com.example.withmehome

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url
import java.net.URL

interface WriteRecruitmentService {

    @POST("/api/meets")
    @Headers("accept: application/json", "Content-type: application/json")
    fun getWriteRecData(@Body jsonparams: RecData )
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