package com.example.glea.datamanager.network.response.model

import com.squareup.moshi.Json

class Type {
    @Json(name = "slot")
    var typeOrder: Int? = null

    @Json(name = "type")
    var typeDetails: Name? = null
}