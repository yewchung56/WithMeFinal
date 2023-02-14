package com.example.withmehome


import com.squareup.moshi.Json
import retrofit2.http.FormUrlEncoded
import retrofit2.http.PUT

data class MeetFormRequest(
    @Json(name = "addresses")
    val addresses: List<Addresse>?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "maxPeople")
    val maxPeople: Int?,
    @Json(name = "meetCategory")
    val meetCategory: String?,
    @Json(name = "minPeople")
    val minPeople: Int?,
    @Json(name = "title")
    val title: String?
)
interface WriteRecService(
    /*@PUT("/api/meets")*/

)
