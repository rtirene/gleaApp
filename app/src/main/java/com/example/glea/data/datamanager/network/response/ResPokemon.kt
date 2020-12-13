package com.example.glea.data.datamanager.network.response

import com.example.glea.data.datamanager.network.response.model.RetrievedImages
import com.example.glea.data.datamanager.network.response.model.Name
import com.example.glea.data.datamanager.network.response.model.RetrievedStat
import com.example.glea.data.datamanager.network.response.model.Type
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class ResPokemon : Name() {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName( "sprites")
    var sprites: RetrievedImages? = null

    @SerializedName("stats")
    var stats: List<RetrievedStat>? = null

    @SerializedName("types")
    var types: List<Type>? = null
}