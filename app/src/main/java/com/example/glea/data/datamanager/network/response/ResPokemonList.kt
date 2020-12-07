package com.example.glea.data.datamanager.network.response

import com.example.glea.datamanager.network.response.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResPokemonList {

    @Json(name = "count")
    var pokemonCount: Int? = null

    @Json(name = "results")
    var pokemonList: List<Pokemon>? = null
}