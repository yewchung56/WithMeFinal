package com.example.withmehome


import com.squareup.moshi.Json

data class LoginData(
    @Json(name = "data")
    val `data`: LoginAccessData?,
    @Json(name = "success")
    val success: Boolean?
)

data class LoginAccessData(
    @Json(name = "accessToken")
    val accessToken: String?,
    @Json(name = "addressExistence")
    val addressExistence: Boolean?,
    @Json(name = "phoneNumberExistence")
    val phoneNumberExistence: Boolean?
)