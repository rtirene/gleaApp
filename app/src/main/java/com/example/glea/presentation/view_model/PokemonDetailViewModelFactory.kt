package com.example.glea.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.repository.PokemonDetailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PokemonDetailViewModelFactory(
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val pokemonDb: PokemonDb,
    private val mapper: PokemonDetailMapper,
    private val name: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)) {
            return PokemonDetailViewModel(
                PokemonDetailRepository(pokemonDetailApiHelper, mapper, pokemonDb),
                name
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}