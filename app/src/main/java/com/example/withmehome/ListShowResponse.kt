package com.example.withmehome


import com.squareup.moshi.Json

data class ListShowResponse(
    @Json(name = "data")
    val `data`: DataListShow?,
    @Json(name = "success")
    val success: Boolean?
)

data class Address(
    @Json(name = "sgg")
    val sgg: String?,
    @Json(name = "sido")
    val sido: String?
)

data class Addresse(
    @Json(name = "sgg")
    val sgg: String?,
    @Json(name = "sido")
    val sido: String?
)

data class DataListShow(
    @Json(name = "meetInfoGetResponses")
    val meetInfoGetResponses: List<MeetInfoGetResponse?>?
)

data class Leader(
    @Json(name = "address")
    val address: Address?,
    @Json(name = "ageRange")
    val ageRange: Int?,
    @Json(name = "gender")
    val gender: String?,
    @Json(name = "nickname")
    val nickname: String?,
    @Json(name = "phoneNumber")
    val phoneNumber: String?,
    @Json(name = "profileImage")
    val profileImage: String?
)

data class MeetInfoGetResponse(
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
<<<<<<< HEAD
=======
)

data class Data(
    @Json(name = "addresses")
    val addresses: List<Addresse?>?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "endDate")
    val endDate: Any?,
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
    @Json(name = "meetStatus")
    val meetStatus: Any?,
    @Json(name = "membersCount")
    val membersCount: Int?,
    @Json(name = "minPeople")
    val minPeople: Int?,
    @Json(name = "recruitStatus")
    val recruitStatus: String?,
    @Json(name = "startDate")
    val startDate: Any?,
    @Json(name = "title")
    val title: String?
>>>>>>> c8115a91c44c9b9671ac33acd27c939e30571dbf
)