package com.example.glea.datamanager.network.response.model

import com.squareup.moshi.Json

open class Name {
    @Json(name = "name")
    var name: String? = null
}