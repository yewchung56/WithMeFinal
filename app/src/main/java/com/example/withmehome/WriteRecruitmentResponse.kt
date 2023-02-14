package com.example.withmehome


import com.squareup.moshi.Json

data class WriteRecruitmentResponse(
    @Json(name = "meetFormRequest")
    val meetFormRequest: MeetFormRequest?,
    @Json(name = "meetImage")
    val meetImage: String?
)