package com.example.glea.data.repository

import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper

class PokemonDetailRepository(private val pokemonDetailApiHelper: PokemonDetailApiHelper) {
    suspend fun getPokemon(name: String) = pokemonDetailApiHelper.getPokemon(name)
}