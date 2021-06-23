package com.example.glea.domain.usecases

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class GetPokemonList(private val pokemonListRepository: PokemonListRepository) {
    suspend operator fun invoke(): Flow<PagingData<Pokemon>> =
        pokemonListRepository.getPokemonList()
}