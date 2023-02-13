package com.example.withmehome

import retrofit2.Call
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
    fun getWriteRecData(@Body meets: RecData): Call<WriteRecruitmentResponse>
        /*Field("addresses")  addresses : Addresses?,
        @Field("meetCategory") meetCategory: String?,
        @Field("title") title: String?,
        @Field("link") link: String?,
        @Field("content") content: String?,
        @Field("minPeople") minPeople: Int?,
        @Field("maxPeople") maxPeople: Int?,*/


    //@Query ("meetId") meetId: Int?
        /*@Body addresses: Addresses,
                        @Body meetCategory: String,
                        @Body title: String,
                        @Query ("link") link: String,
                        @Query ("content") content: String,
                        @Query ("minPeople") minPeople: Int,
                        @Query ("maxPeople") maxPeople: Int)*/



}