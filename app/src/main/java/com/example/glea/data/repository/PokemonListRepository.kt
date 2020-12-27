package com.example.glea.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.data.repository.list_source.PokemonListPagingSource
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

class PokemonListRepository(private val pokemonListApiHelper: PokemonListApiHelper) {

    companion object {
        private const val POKE_LIST_SIZE = 20
    }

    fun getPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = POKE_LIST_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { PokemonListPagingSource(pokemonListApiHelper) }
        ).flow
    }
}