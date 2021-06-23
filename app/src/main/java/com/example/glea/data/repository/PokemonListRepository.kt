package com.example.glea.data.repository

import androidx.paging.PagingData
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    suspend fun getPokemonList(): Flow<PagingData<Pokemon>>
}