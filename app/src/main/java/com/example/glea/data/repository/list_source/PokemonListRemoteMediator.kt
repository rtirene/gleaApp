package com.example.glea.data.repository.list_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.data.datamanager.persistence.PokemonDb
import retrofit2.HttpException
import java.io.IOException
import androidx.room.withTransaction
import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.entities.PokemonListElement
import com.example.glea.data.datamanager.entities.PokemonListElementRemoteKeys
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.persistence.PokemonDao
import com.example.glea.data.datamanager.persistence.PokemonListDao
import com.example.glea.data.datamanager.persistence.RemoteKeysDao
import java.io.InvalidObjectException


@OptIn(ExperimentalPagingApi::class)
class PokemonListRemoteMediator(
    private val pokemonListApiHelper: PokemonListApiHelper,
    private val pokemonDetailApiHelper: PokemonDetailApiHelper,
    private val pokemonDb: PokemonDb
) : RemoteMediator<Int, PokemonDetail>() {

    private val listDao: PokemonListDao = pokemonDb.pokemonList()
    private val remoteKeysDao: RemoteKeysDao = pokemonDb.pokemonListRemoteKeys()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonDetail>
    ): MediatorResult {
        try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextKey?.minus(1) ?: STARTING_INDEX
                }
                LoadType.PREPEND -> {
                    return MediatorResult.Success(true)
                }
                LoadType.APPEND -> {
                    try {
                        val remoteKeys = getRemoteKeyForLastItem(state)
                        remoteKeys?.nextKey ?: return MediatorResult.Success(true)
                    } catch (e: InvalidObjectException) {
                        return MediatorResult.Error(e)
                    }
                }
            }
            val pokemonList = pokemonListApiHelper.getPokemonList(
                limit = state.config.pageSize,
                offset = page * state.config.pageSize
            )

            val pokemonDetailedList = pokemonList.map { pokemonListElement ->
                pokemonDetailApiHelper.getPokemon(pokemonListElement.name)
            }

            val endOfPaginationReached = pokemonDetailedList.size < state.config.pageSize

            pokemonDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    listDao.deleteList()
                    remoteKeysDao.clearRemoteKeys()
                }


                val prevKey = if (page == STARTING_INDEX) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1
                val keys = pokemonList.map {
                    PokemonListElementRemoteKeys(
                        name = it.name,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                listDao.insertAll(pokemonDetailedList)
                pokemonDb.pokemonListRemoteKeys().insertAll(keys)


            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)

        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, PokemonDetail>): PokemonListElementRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            .let { pokemon ->
                pokemonDb.withTransaction {
                    pokemonDb.pokemonListRemoteKeys().remoteKeyByPokemonName(pokemon?.name)
                }
            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, PokemonDetail>): PokemonListElementRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.name?.let { name ->
                pokemonDb.withTransaction {
                    pokemonDb.pokemonListRemoteKeys().remoteKeyByPokemonName(name)
                }
            }
        }

    }

    companion object {
        const val STARTING_INDEX = 0
    }


}