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
import retrofit2.http.*

interface WriteRecruitmentService {

    /*data class Addresses (
        val addresses: List<Addresses>
    ) {*/
        data class Addresses(
            val sido: String?,
            val sgg: String?
        )


    data class RecData(
        val addresses: Addresses?,
        val meetCategory: String? = null,
        val title: String? = null,
        val link: String? = null,
        val content: String? = null,
        val minPeople: Int? = null,
        val maxPeople: Int? = null
    )



    @POST("/api/meets")
    @Headers("accept: application/json", "content-type: application/json")
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