package com.example.withmehome


import com.squareup.moshi.Json

data class KakaoData(
    @Json(name = "kakaoAccessToken")
    val kakaoAccessToken: String?
)