package com.example.glea.data.datamanager.entities

import com.google.gson.annotations.SerializedName

data class Sprites (
    @SerializedName("front_default")
    val front_default: String?,
    @SerializedName("back_default")
    val back_default: String?
)