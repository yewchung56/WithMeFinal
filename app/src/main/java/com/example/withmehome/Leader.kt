package com.example.withmehome


import com.squareup.moshi.Json

data class Leader(
    @field:Json(name = "memberId")
    val memberId: Int?,
    @field:Json(name = "nickname")
    val nickname: String?,
    @field:Json(name = "profileImage")
    val profileImage: String?,
    @field:Json(name = "sggAddress")
    val sggAddress: String?,
    @field:Json(name = "trustPoint")
    val trustPoint: Int?
)