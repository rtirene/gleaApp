package com.example.glea.data.datamanager.network.response.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

class Type {
    @SerializedName("slot")
    var typeOrder: Int? = null

    @SerializedName("type")
    var typeDetails: Name? = null
}