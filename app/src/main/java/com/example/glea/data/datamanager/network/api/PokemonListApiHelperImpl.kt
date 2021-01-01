package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.entities.PokemonListElement
import com.example.glea.data.datamanager.network.service.RetrofitServiceBuilder

class PokemonListApiHelperImpl constructor(
    private val builder: RetrofitServiceBuilder
) : PokemonListApiHelper {
    override suspend fun getPokemonList(limit: Int?, offset: Int?): List<PokemonListElement> {
        return builder.api.getPokemonList(limit, offset).results
    }
}