package com.example.glea.data.datamanager.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonList (
    @Json(name = "count")
    val count: Int?,

    @Json(name = "results")
    val results: List<PokemonListElement>
)
