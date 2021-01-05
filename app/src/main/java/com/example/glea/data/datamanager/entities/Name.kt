package com.example.glea.data.datamanager.entities

import androidx.annotation.NonNull
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Name(
    @PrimaryKey
    @NonNull
    @Json(name = "name")
    val name: String
)