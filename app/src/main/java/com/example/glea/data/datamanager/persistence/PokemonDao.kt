package com.example.glea.data.datamanager.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.glea.data.datamanager.entities.PokemonDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonDetail?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<PokemonDetail?>)

    @Query("SELECT * FROM pokemon_detail WHERE name = :name")
    fun selectPokemonByName(name: String): PokemonDetail?

    @Query("DELETE FROM pokemon_detail WHERE name = :name")
    suspend fun deletePokemon(name: String?)
}