package com.example.glea.datamanager.network.response.model

import com.squareup.moshi.Json


class Pokemon : Name() {
    @Json(name = "url")
    var retrievalUrl: String? = null
}