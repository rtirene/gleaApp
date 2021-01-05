package com.example.glea.data.datamanager.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Type (
    @Json(name = "slot")
    val typeOrder: Int? = null,

    @Json(name = "type")
    val typeDetails: Name? = null
)