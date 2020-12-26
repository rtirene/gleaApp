package com.example.glea.domain.usecases

import androidx.paging.PagingData
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow


class GetPokemonList(private val pokemonListRepository: PokemonListRepository) {
    operator fun invoke() : Flow<PagingData<Pokemon>> = pokemonListRepository.getPokemonList()
}