package com.example.glea.domain.usecases

import androidx.lifecycle.LiveData
import com.example.glea.data.repository.PokemonDetailRepository
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow


class GetSelectedPokemon(val pokemonDetailRepository: PokemonDetailRepository) {
    suspend operator fun invoke(name: String): Pokemon? = pokemonDetailRepository.getPokemon(name)
}