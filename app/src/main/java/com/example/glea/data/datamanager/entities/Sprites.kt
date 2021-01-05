package com.example.glea.data.datamanager.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sprites (
    @Json(name = "front_default")
    val front_default: String?,
    @Json(name = "back_default")
    val back_default: String?
)