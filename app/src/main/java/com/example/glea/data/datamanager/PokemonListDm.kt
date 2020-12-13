package com.example.glea.data.datamanager

import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.domain.models.Pokemon
import com.example.glea.data.datamanager.network.mappers.PokemonListMapper
import com.example.glea.datamanager.network.service.RetrofitServiceBuilder

class PokemonListDm constructor(
    private val mapper: PokemonListMapper,
    private val builder: RetrofitServiceBuilder
) : PokemonListApiHelper {
    override suspend fun getPokemonList(): List<Pokemon>? {
        return mapper.map(builder.api.getPokemonList())
    }

}