package com.example.glea.data.datamanager.network.response.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

open class Name {
    @SerializedName("name")
    var name: String? = null
}