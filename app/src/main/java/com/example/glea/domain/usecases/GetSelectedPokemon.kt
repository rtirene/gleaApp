package com.example.glea.domain.usecases

import com.example.glea.data.repository.PokemonDetailRepository
import com.example.glea.domain.models.Pokemon


class GetSelectedPokemon(val pokemonDetailRepository: PokemonDetailRepository) {
    suspend operator fun invoke(name: String): Pokemon = pokemonDetailRepository.getPokemon(name)
}