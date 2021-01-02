package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.entities.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokemonDetailApiHelper {
    suspend fun getPokemon(name: String): PokemonDetail?
}