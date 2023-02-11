package com.example.withmehome


import com.squareup.moshi.Json

data class WriteRecruitmentResponse(
    @Json(name = "data")
    val `data`: DataWriteRec?,
    @Json(name = "success")
    val success: Boolean?
)

data class DataWriteRec(
    @Json(name = "meetId")
    val meetId: Int?
)