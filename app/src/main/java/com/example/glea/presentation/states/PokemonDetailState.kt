package com.example.glea.presentation.states

import com.example.glea.domain.models.Pokemon

sealed class PokemonDetailState {
    object Loading : PokemonDetailState()
    data class PokemonDetail(val pokemon: Pokemon) : PokemonDetailState()
    data class Error(val error: String?) : PokemonDetailState()
}