package com.example.glea.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.map
import androidx.room.withTransaction
import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.lang.Exception

class PokemonDetailRepository(
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val mapper: PokemonDetailMapper,
    private val pokemonDb: PokemonDb
) {
    suspend fun getPokemon(name: String): Pokemon? {
        return try {
            mapper.map(pokemonDetailApiHelper.getPokemon(name))
        } catch (e: Exception) {
            mapper.map(pokemonDb.pokemonList().getPokemonByName(name))
        }
    }
}
