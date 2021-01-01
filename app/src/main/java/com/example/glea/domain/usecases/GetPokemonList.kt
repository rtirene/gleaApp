package com.example.glea.domain.usecases

import android.net.Uri
import androidx.paging.PagingData
import com.example.glea.data.datamanager.entities.PokemonListElement
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.domain.models.Images
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetPokemonList(private val pokemonListRepository: PokemonListRepository) {
    operator fun invoke(): Flow<PagingData<Pokemon>> = pokemonListRepository.getPokemonList().map {
        it.map {element ->
            Pokemon(element.name, Images(element.getUrlFrontImage()))
        }
    }
}