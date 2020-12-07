package com.example.glea.domain.usecases

import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.models.Pokemon


class GetPokemonList(val pokemonListRepository: PokemonListRepository) {
    suspend operator fun invoke() : List<Pokemon>? = pokemonListRepository.getPokemonList()
}