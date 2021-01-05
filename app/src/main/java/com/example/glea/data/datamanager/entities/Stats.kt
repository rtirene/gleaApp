package com.example.glea.data.datamanager.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stats(
    @Json(name = "base_stat")
    val base_stat: Int?,

    @Json(name = "effort")
    val effort: Int?,

    @Json(name = "stat")
    val stat: Name?
)