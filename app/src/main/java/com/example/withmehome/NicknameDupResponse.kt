package com.example.withmehome


import com.squareup.moshi.Json

data class NicknameDupResponse(
    @field:Json(name = "data")
    val `data`: DataNickDup?,
    @field:Json(name = "success")
    val success: Boolean?
)

data class DataNickDup(
    @field:Json(name = "duplicated")
    val duplicated: Boolean?,
    @field:Json(name = "meetInfoGetResponses")
    val meetInfoGetResponses: List<MeetInfoGetResponse>
)