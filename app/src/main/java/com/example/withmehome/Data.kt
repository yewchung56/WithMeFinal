package com.example.withmehome


import com.squareup.moshi.Json

data class Data(
    @Json(name = "addresses")
    val addresses: List<Addresse?>?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "endDate")
    val endDate: String?,
    @Json(name = "leader")
    val leader: Leader?,
    @Json(name = "likeCount")
    val likeCount: Int?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "maxPeople")
    val maxPeople: Int?,
    @Json(name = "meetCategory")
    val meetCategory: String?,
    @Json(name = "meetId")
    val meetId: Int?,
    @Json(name = "meetImage")
    val meetImage: String?,
    @Json(name = "meetStatus")
    val meetStatus: String?,
    @Json(name = "membersCount")
    val membersCount: Int?,
    @Json(name = "minPeople")
    val minPeople: Int?,
    @Json(name = "recruitStatus")
    val recruitStatus: String?,
    @Json(name = "startDate")
    val startDate: String?,
    @Json(name = "title")
    val title: String?
)