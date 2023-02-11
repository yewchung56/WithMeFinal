package com.example.withmehome


import com.squareup.moshi.Json

data class LoginUserResponse(
    @Json(name = "data")
    val `data`: DataLogin?,
    @Json(name = "success")
    val success: Boolean?
)