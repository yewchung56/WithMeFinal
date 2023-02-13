package com.example.withmehome


import com.squareup.moshi.Json

data class WriteRecruitmentResponse(
    @field:Json(name = "data")
    val `data`: DataWriteRec?,
    @field:Json(name = "success")
    val success: Boolean?
)

data class DataWriteRec(
    @field:Json(name = "meetId")
    val meetId: Int?
)