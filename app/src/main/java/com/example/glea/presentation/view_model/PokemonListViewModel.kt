package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.usecases.GetPokemonList
import com.example.glea.presentation.intent.PokemonIntent
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
class PokemonListViewModel(
    private val pokemonListRepository: PokemonListRepository
) : ViewModel() {

    val pokemonIntent = Channel<PokemonIntent>(Channel.UNLIMITED)
    val state = MutableStateFlow<PokemonListState>(PokemonListState.Init)


    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            pokemonIntent.consumeAsFlow().collect {
                when (it) {
                    is PokemonIntent.FetchPokemonList -> fetchPokemonList()
                }
            }
        }
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            state.value = PokemonListState.Loading
            //update state by fetching the list
            state.value = try {
                PokemonListState.PokemonList(GetPokemonList(pokemonListRepository).invoke())
            } catch (e: Exception) {
                PokemonListState.Error(e.localizedMessage)
            }
        }

    }

}


