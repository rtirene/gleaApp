package com.example.glea.data.repository

import androidx.paging.*
import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.repository.list_source.PokemonListRemoteMediator
import com.example.glea.domain.models.Images
import com.example.glea.domain.models.Pokemon
import com.example.glea.domain.models.Stat
import com.example.glea.domain.models.Type
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@ExperimentalPagingApi
class PokemonListRepositoryImpl(
    private val pokemonListApiHelper: PokemonListApiHelper,
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val pokemonDb: PokemonDb

) : PokemonListRepository {

    fun setUpPagingData(): Flow<PagingData<PokemonDetail>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true
            ),
            remoteMediator = PokemonListRemoteMediator(
                pokemonListApiHelper,
                pokemonDetailApiHelper,
                pokemonDb
            ),
            pagingSourceFactory = { pokemonDb.pokemonList().getStoredPokemonList() }

        ).flow
    }

    override suspend fun getPokemonList() = setUpPagingData().map { pagingData ->
        pagingData.map {
            it.toPokemonModel()
        }
    }
}

internal fun PokemonDetail.toPokemonModel() = Pokemon(
    name = name,
    imgs = Images(sprites?.front_default, sprites?.back_default),
    stats = stats?.map {
        Stat(name = it.stat?.name, value = it.base_stat, effort = it.effort)
    },
    type = types?.map {
        Type(order = it.typeOrder, typeName = it.typeDetails?.name)
    }

)
