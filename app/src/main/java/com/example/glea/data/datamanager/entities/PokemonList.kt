package com.example.glea.data.datamanager.model

import com.google.gson.annotations.SerializedName

class PokemonList {
    @SerializedName("count")
    var count: Int? = null

    @SerializedName("results")
    var results: List<PokemonListElement>? = null
}
