package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.data.repository.PokemonListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PokemonListViewModelFactory(private val pokemonListApiHelper: PokemonListApiHelper) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java)) {
            return PokemonListViewModel(PokemonListRepository(pokemonListApiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}