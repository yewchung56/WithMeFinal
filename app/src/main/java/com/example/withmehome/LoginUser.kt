package com.example.withmehome


import com.squareup.moshi.Json

data class LoginUser(
    @Json(name = "data")
    val `data`: DataX?,
    @Json(name = "success")
    val success: Boolean?
)