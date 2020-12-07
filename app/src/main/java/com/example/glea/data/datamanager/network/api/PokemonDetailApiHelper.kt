package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.network.response.ResPokemon
import com.example.glea.data.datamanager.network.response.ResPokemonList
import com.example.glea.domain.models.Pokemon

interface PokemonDetailApiHelper {
    suspend fun getPokemon(name: String): Pokemon
}