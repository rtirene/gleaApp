package com.example.glea.presentation.states

import androidx.lifecycle.LiveData
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

sealed class PokemonDetailState {
    object Init : PokemonDetailState()
    object Loading : PokemonDetailState()
    data class PokemonDetail(val pokemon: Pokemon?) : PokemonDetailState()
    data class Error(val error: String?) : PokemonDetailState()
}