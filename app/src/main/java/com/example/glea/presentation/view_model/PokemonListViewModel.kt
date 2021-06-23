package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.usecases.GetPokemonList
import com.example.glea.presentation.intent.PokemonIntent
import com.example.glea.presentation.states.PokemonListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@ExperimentalPagingApi
class PokemonListViewModel(
    private val fetchPokemonList: GetPokemonList,
) : ViewModel() {
    val pokemonIntent = Channel<PokemonIntent>(Channel.UNLIMITED)
    val state = MutableStateFlow<PokemonListState>(PokemonListState.Loading)

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
            fetchPokemonList.invoke().cachedIn(viewModelScope)
                .collectLatest {
                    state.value = PokemonListState.PokemonList(it)
                }
        }
    }
}


