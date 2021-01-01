package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.entities.PokemonDetail

interface PokemonDetailApiHelper {
    suspend fun getPokemon(name: String): PokemonDetail?
}