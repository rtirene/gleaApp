package com.example.glea.data.datamanager.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.entities.PokemonListElement
import com.example.glea.data.datamanager.entities.PokemonListElementRemoteKeys
import com.example.glea.data.datamanager.persistence.type_converters.SpritesTypeConverter
import com.example.glea.data.datamanager.persistence.type_converters.StatsTypeConverter
import com.example.glea.data.datamanager.persistence.type_converters.TypesTypeConverter


@Database(
    entities = [PokemonListElement::class, PokemonDetail::class, PokemonListElementRemoteKeys::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [SpritesTypeConverter::class, StatsTypeConverter::class, TypesTypeConverter::class])

abstract class PokemonDb : RoomDatabase() {
    companion object {
        fun create(context: Context, useInMemory: Boolean): PokemonDb {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, PokemonDb::class.java)
            } else {
                Room.databaseBuilder(context, PokemonDb::class.java, "pokemon.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun pokemonList(): PokemonListDao
    abstract fun pokemonDetail(): PokemonDao
    abstract fun pokemonListRemoteKeys(): RemoteKeysDao
}