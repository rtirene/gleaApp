package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.usecases.GetPokemonList
import com.example.glea.presentation.intent.PokemonIntent
import com.example.glea.presentation.states.PokemonListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class PokemonListViewModel(
    private val pokemonListRepository: PokemonListRepository,
    private val pokemonMapper: PokemonDetailMapper
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
                    is PokemonIntent.FetchFilteredPokemonList -> fetchFilteredPokemonList(it.typeName)
                }
            }
        }
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            state.value = PokemonListState.Loading
            GetPokemonList(pokemonListRepository, pokemonMapper).invoke().cachedIn(viewModelScope)
                .collectLatest {
                    state.value = PokemonListState.PokemonList(it)
                }
        }
    }

    private fun fetchFilteredPokemonList(typeName: String) {
        viewModelScope.launch {
            state.value = PokemonListState.Loading
            GetPokemonList(pokemonListRepository, pokemonMapper).invoke().cachedIn(viewModelScope)
                .collect {
                    state.value = PokemonListState.PokemonList(it.filter { pokemon ->
                        pokemon.type!!.any { type ->
                            type?.typeName == typeName
                        }
                    })
                }
        }

    }

}


