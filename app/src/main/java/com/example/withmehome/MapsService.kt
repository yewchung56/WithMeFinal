package com.example.withmehome

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MapsService {
        @GET("/api/members/address")
        fun getAddressData(@Query("Nickname") nickname : String) : Call<LoginUser>
}