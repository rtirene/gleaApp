package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.repository.PokemonDetailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PokemonDetailViewModelFactory(
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val name: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)) {
            return PokemonDetailViewModel(
                PokemonDetailRepository(pokemonDetailApiHelper),
                name
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}