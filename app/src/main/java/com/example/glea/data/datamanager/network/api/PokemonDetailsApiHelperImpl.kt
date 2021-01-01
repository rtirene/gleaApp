package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.network.service.RetrofitServiceBuilder

class PokemonDetailsApiHelperImpl constructor(
    private val builder: RetrofitServiceBuilder
) : PokemonDetailApiHelper {
    override suspend fun getPokemon(name: String): PokemonDetail {
        return builder.api.getPokemonDetail(name)
    }
}