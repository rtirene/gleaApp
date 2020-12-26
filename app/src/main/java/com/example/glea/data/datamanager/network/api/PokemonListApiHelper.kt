package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.network.response.ResPokemonList
import com.example.glea.domain.models.Pokemon

interface PokemonListApiHelper {
    suspend fun getPokemonList(limit: Int?, offset: Int?): List<Pokemon>?
}