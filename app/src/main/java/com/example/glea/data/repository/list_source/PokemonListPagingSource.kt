package com.example.glea.data.repository.list_source

import androidx.paging.PagingSource
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.domain.models.Pokemon
import retrofit2.HttpException
import java.io.IOException

class PokemonListPagingSource(private val pokemonListApiHelper: PokemonListApiHelper):PagingSource<Int, Pokemon>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val index = params.key ?: STARTING_INDEX
            val pokemonList = pokemonListApiHelper.getPokemonList(LIST_LIMIT, index * LIST_LIMIT)
            LoadResult.Page(
                data = pokemonList!!,
                prevKey = null,
                nextKey = if (pokemonList.isEmpty()) null else index + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIST_LIMIT = 20
        private const val STARTING_INDEX = 0
    }

}