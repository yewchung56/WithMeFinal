package com.example.withmehome


import com.squareup.moshi.Json

data class NicknameSetResponse(
    @Json(name = "success")
    val success: Boolean?
)