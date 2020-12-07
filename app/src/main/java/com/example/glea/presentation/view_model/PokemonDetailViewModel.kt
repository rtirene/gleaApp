package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glea.data.repository.PokemonDetailRepository
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.usecases.GetPokemonList
import com.example.glea.domain.usecases.GetSelectedPokemon
import com.example.glea.presentation.intent.PokemonIntent
import com.example.glea.presentation.states.PokemonDetailState
import com.example.glea.presentation.states.PokemonListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import java.lang.Exception

@ExperimentalCoroutinesApi
class PokemonDetailViewModel(
    private val pokemonDetailsRepository: PokemonDetailRepository,
    private val name: String
) : ViewModel() {

    val pokemonIntent = Channel<PokemonIntent>(Channel.UNLIMITED)
    private val state = MutableStateFlow<PokemonDetailState>(PokemonDetailState.Init)


    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            pokemonIntent.consumeAsFlow().collect {
                when (it) {
                    is PokemonIntent.FetchPokemonDetail -> fetchPokemon()
                }
            }
        }
    }

    private fun fetchPokemon() {
        viewModelScope.launch {
            state.value = PokemonDetailState.Loading
            //update state by fetching the selected pokemon
            state.value = try {
                PokemonDetailState.PokemonDetail(GetSelectedPokemon(pokemonDetailsRepository).invoke(name))
            } catch (e: Exception) {
                PokemonDetailState.Error(e.localizedMessage)
            }
        }

    }

}


