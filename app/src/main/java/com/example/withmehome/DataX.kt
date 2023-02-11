package com.example.withmehome


import com.squareup.moshi.Json

data class DataX(
    @Json(name = "accessToken")
    val accessToken: String?,
    @Json(name = "addressExistence")
    val addressExistence: Boolean?,
    @Json(name = "phoneNumberExistence")
    val phoneNumberExistence: Boolean?
)