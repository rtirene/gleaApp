package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.repository.PokemonListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PokemonListViewModelFactory(
    private val pokemonListApiHelper: PokemonListApiHelper,
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val pokemonDb: PokemonDb,
    private val mapper: PokemonDetailMapper
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java)) {
            return PokemonListViewModel(
                PokemonListRepository(
                    pokemonListApiHelper,
                    pokemonDetailApiHelper,
                    pokemonDb
                ),
                mapper
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}