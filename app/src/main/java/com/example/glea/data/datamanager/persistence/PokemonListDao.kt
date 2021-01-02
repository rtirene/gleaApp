package com.example.glea.data.datamanager.persistence

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.entities.PokemonListElement
import com.example.glea.domain.models.Pokemon
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<PokemonDetail?>)

    @Query("SELECT * FROM pokemon_detail")
    fun getStoredPokemonList(): PagingSource<Int, PokemonDetail>

    @Query("SELECT * FROM pokemon_detail WHERE name = :name")
    suspend fun getPokemonByName(name : String) : PokemonDetail?

    @Query("DELETE FROM pokemon_detail")
    suspend fun deleteList()
}