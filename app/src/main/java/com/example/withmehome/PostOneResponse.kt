package com.example.withmehome


import com.squareup.moshi.Json

data class PostOneResponse(
    @Json(name = "data")
    val `data`: Data?,
    @Json(name = "success")
    val success: Boolean?
)