package com.example.glea.datamanager

import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.network.response.ResPokemon
import com.example.glea.datamanager.network.mappers.PokemonDetailMapper
import com.example.glea.datamanager.network.service.RetrofitServiceBuilder
import com.example.glea.domain.models.Pokemon

class PokemonDetailsDm constructor(
    private val mapper: PokemonDetailMapper,
    private val builder: RetrofitServiceBuilder
) : PokemonDetailApiHelper {
    override suspend fun getPokemon(name: String): Pokemon {
        return mapper.map(builder.createService().getPokemonDetail(name))
    }
}