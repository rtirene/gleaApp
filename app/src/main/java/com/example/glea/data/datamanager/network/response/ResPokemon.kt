package com.example.glea.data.datamanager.network.response

import com.example.glea.datamanager.network.response.model.RetrievedImages
import com.example.glea.datamanager.network.response.model.Name
import com.example.glea.datamanager.network.response.model.RetrievedStat
import com.example.glea.datamanager.network.response.model.Type
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResPokemon : Name() {
    @Json(name = "id")
    var id: Int? = null

    @Json(name = "sprites")
    var images: RetrievedImages? = null

    @Json(name = "stats")
    var stats: List<RetrievedStat>? = null

    @Json(name = "types")
    var types: List<Type>? = null
}