package com.example.glea.data.datamanager.entities

import com.google.gson.annotations.SerializedName

data class Type (
    @SerializedName("slot")
    val typeOrder: Int? = null,

    @SerializedName("type")
    val typeDetails: Name? = null
)