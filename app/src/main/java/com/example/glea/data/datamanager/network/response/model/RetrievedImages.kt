package com.example.glea.datamanager.network.response.model

import com.squareup.moshi.Json

class RetrievedImages {
    @Json(name = "front_shiny")
    var frontImage: String? = null

    @Json(name = "back_shiny")
    var backImage: String? = null
}