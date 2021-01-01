package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.entities.PokemonListElement


interface PokemonListApiHelper {
    suspend fun getPokemonList(limit: Int? = null, offset: Int? = null): List<PokemonListElement>
}