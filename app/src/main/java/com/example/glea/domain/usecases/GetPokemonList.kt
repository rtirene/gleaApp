package com.example.glea.domain.usecases

import androidx.paging.PagingData
import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetPokemonList(private val pokemonListRepository: PokemonListRepository, private val mapper : PokemonDetailMapper) {
    operator fun invoke(): Flow<PagingData<Pokemon>> = pokemonListRepository.getPokemonList().map {
        it.map { element ->
            mapper.map(element)
        }
    }
}