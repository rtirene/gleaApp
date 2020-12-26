package com.example.glea.presentation.states

import androidx.paging.PagingData
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

sealed class PokemonListState {
    object Init : PokemonListState()
    object Loading : PokemonListState()
    data class PokemonList(val pokeList: Flow<PagingData<Pokemon>>) : PokemonListState()
    data class Error(val error: String?) : PokemonListState()
}