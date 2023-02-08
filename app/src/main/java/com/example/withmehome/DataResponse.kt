package com.example.withmehome


import com.squareup.moshi.Json

data class DataResponse(
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "nickname")
    val nickname: String?,
    @field:Json(name = "startDate")
    val startDate: String?,
    @field:Json(name = "likeCount")
    val likeCount: Int?,
    @field:Json(name = "meetStatus")
    val meetStatus: String?,
    @field:Json(name = "meetCategory")
    val meetCategory: String?,
)