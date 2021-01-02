package com.example.glea.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.entities.PokemonListElement
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.repository.list_source.PokemonListRemoteMediator
import kotlinx.coroutines.flow.Flow

class PokemonListRepository(
    private val pokemonListApiHelper: PokemonListApiHelper,
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val pokemonDb: PokemonDb

) {

    companion object {
        private const val POKE_LIST_SIZE = 20
    }

    fun getPokemonList(): Flow<PagingData<PokemonDetail>> {
        return Pager(
            config = PagingConfig(
                pageSize = POKE_LIST_SIZE,
                enablePlaceholders = true
            ),
            remoteMediator = PokemonListRemoteMediator(
                pokemonListApiHelper,
                pokemonDetailApiHelper,
                pokemonDb
            ),
            pagingSourceFactory = { pokemonDb.pokemonList().getStoredPokemonList()}

        ).flow
    }
}