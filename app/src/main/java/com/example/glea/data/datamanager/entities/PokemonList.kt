package com.example.glea.data.datamanager.entities

import com.google.gson.annotations.SerializedName

data class PokemonList (
    @SerializedName("count")
    val count: Int?,

    @SerializedName("results")
    val results: List<PokemonListElement>
)
