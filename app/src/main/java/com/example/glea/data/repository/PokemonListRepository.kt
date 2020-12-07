package com.example.glea.data.repository

import com.example.glea.data.datamanager.network.api.PokemonListApiHelper

class PokemonListRepository(private val pokemonListApiHelper: PokemonListApiHelper) {
    suspend fun getPokemonList() = pokemonListApiHelper.getPokemonList()
}