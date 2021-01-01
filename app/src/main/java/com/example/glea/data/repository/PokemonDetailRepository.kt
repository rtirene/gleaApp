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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.lang.Exception

class PokemonDetailRepository(
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val mapper: PokemonDetailMapper,
    private val pokemonDb: PokemonDb
) {
    suspend fun getPokemon(name: String): Pokemon? {
        return try {
            val pokemon = pokemonDetailApiHelper.getPokemon(name)
            pokemonDb.withTransaction {
                pokemonDb.pokemonDetail().insert(pokemon)
            }
            mapper.map(pokemon)
        } catch (e: Exception) {
            mapper.map(pokemonDb.pokemonDetail().selectPokemonByName(name))
        }
    }
}
