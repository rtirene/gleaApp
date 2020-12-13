package com.example.glea.data.datamanager.network.response.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


class Pokemon : Name() {
    @SerializedName("url")
    var url: String? = null
}