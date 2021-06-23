package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.network.service.RetrofitServiceBuilder
import kotlinx.coroutines.flow.Flow

class PokemonDetailsApiHelperImpl constructor(
    private val builder: RetrofitServiceBuilder
) : PokemonDetailApiHelper {
    override suspend fun getPokemon(name: String): PokemonDetail? {
        return builder.api.getPokemonDetail(name)
    }

    override suspend fun getPokemonByUrl(url: String): PokemonDetail? {
        return builder.api.getPokemonDetailByUrl(url)
    }
}