package com.example.glea.data.datamanager.network.response

import com.example.glea.data.datamanager.network.response.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.google.gson.annotations.SerializedName

class ResPokemonList {
    @SerializedName("count")
    var count: Int? = null

    @SerializedName("results")
    var results: List<Pokemon>? = null
}
