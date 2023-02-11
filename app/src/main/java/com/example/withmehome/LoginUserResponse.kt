package com.example.withmehome


import com.squareup.moshi.Json

data class LoginUserResponse(
    @Json(name = "data")
    val `data`: DataLogin?,
    @Json(name = "success")
    val success: Boolean?
)

data class DataLogin(
    @Json(name = "accessToken")
    val accessToken: String?,
    @Json(name = "addressExistence")
    val addressExistence: Boolean?,
    @Json(name = "phoneNumberExistence")
    val phoneNumberExistence: Boolean?
)