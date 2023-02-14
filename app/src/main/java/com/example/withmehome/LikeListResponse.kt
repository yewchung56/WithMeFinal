package com.example.withmehome


import com.squareup.moshi.Json

data class LikeListResponse(
    @field:Json(name = "data")
    val `data`: List<Data>?,
    @field:Json(name = "success")
    val success: Boolean?
)
data class Data(
    @field:Json(name = "addresses")
    val addresses: List<Addresse?>?,
    @field:Json(name = "content")
    val content: String?,
    @field:Json(name = "endDate")
    val endDate: String?,
    @field:Json(name = "leader")
    val leader: Leader?,    //사용자이름
    @field:Json(name = "likeCount")
    val likeCount: Int?,    //찜수
    @field:Json(name = "link")
    val link: String?,
    @field:Json(name = "maxPeople")
    val maxPeople: Int?,
    @field:Json(name = "meetCategory")
    val meetCategory: String?,
    @field:Json(name = "meetId")
    val meetId: Int?,
    @field:Json(name = "meetImage")
    val meetImage: String?,
    @field:Json(name = "meetStatus")
    val meetStatus: String?,
    @field:Json(name = "membersCount")
    val membersCount: Int?,
    @field:Json(name = "minPeople")
    val minPeople: Int?,
    @field:Json(name = "recruitStatus")
    val recruitStatus: String?,
    @field:Json(name = "startDate")
    val startDate: String?,    //시작일
    @field:Json(name = "title")
    val title: String?  //제목
)
data class Addresse(
    @field:Json(name = "sgg")
    val sgg: String?,
    @field:Json(name = "sido")
    val sido: String?
)