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
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject


@Database(
    entities = [PokemonDetail::class, PokemonListElementRemoteKeys::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(value = [SpritesTypeConverter::class, StatsTypeConverter::class, TypesTypeConverter::class])

abstract class PokemonDb : RoomDatabase() {
    companion object {
        fun create(
            context: Context,
            useInMemory: Boolean,
            spritesTypeConverter: SpritesTypeConverter,
            statsTypeConverter: StatsTypeConverter,
            typesTypeConverter: TypesTypeConverter
        ): PokemonDb {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, PokemonDb::class.java)
            } else {
                Room.databaseBuilder(context, PokemonDb::class.java, "pokemon.db")
            }
            return databaseBuilder
                .addTypeConverter(spritesTypeConverter)
                .addTypeConverter(statsTypeConverter)
                .addTypeConverter(typesTypeConverter)
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun pokemonList(): PokemonListDao
    abstract fun pokemonListRemoteKeys(): RemoteKeysDao
}