package com.example.glea.data.datamanager.persistence

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.glea.data.datamanager.entities.PokemonListElement
import com.example.glea.domain.models.Pokemon

@Dao
interface PokemonListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<PokemonListElement>)

    @Query("SELECT * FROM pokemon_list")
    fun getStoredPokemonList(): PagingSource<Int, PokemonListElement>

    @Query("DELETE FROM pokemon_list")
    suspend fun deleteList()
}