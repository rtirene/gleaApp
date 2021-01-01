package com.example.glea.data.datamanager.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.glea.data.datamanager.entities.Name
import com.example.glea.data.datamanager.entities.PokemonListElementRemoteKeys

@Dao
interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(remoteKey: List<PokemonListElementRemoteKeys>)
    @Query("SELECT * FROM remote_keys WHERE name = :name")
    fun remoteKeyByPokemonName(name: String?): PokemonListElementRemoteKeys?
    @Query("DELETE FROM remote_keys")
    fun clearRemoteKeys()
}