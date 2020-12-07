package com.example.glea.presentation.states

import com.example.glea.domain.models.Pokemon

sealed class PokemonListState {
    object Init : PokemonListState()
    object Loading : PokemonListState()
    data class PokemonList(val pokeList: List<Pokemon>?) : PokemonListState()
    data class Error(val error: String?) : PokemonListState()
}