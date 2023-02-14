package com.example.withmehome


import com.squareup.moshi.Json

data class MeetImage(
    @field:Json(name = "fileName")
    val fileName: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "storedFileName")
    val storedFileName: String?,
    @field:Json(name = "url")
    val url: String?
)