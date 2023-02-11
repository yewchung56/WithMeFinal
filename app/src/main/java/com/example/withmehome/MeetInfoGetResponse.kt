package com.example.withmehome

data class MeetInfoGetResponse(
    val addresses: List<Addresse>,
    val content: String,
    val endDate: String,
    val leader: Leader,
    val likeCount: Int,
    val link: String,
    val maxPeople: Int,
    val meetCategory: String,
    val meetId: Int,
    val meetStatus: String,
    val membersCount: Int,
    val minPeople: Int,
    val recruitStatus: String,
    val startDate: String,
    val title: String
)