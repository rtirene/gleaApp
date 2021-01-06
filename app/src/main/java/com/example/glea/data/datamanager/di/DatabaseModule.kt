package com.example.glea.data.datamanager.di

import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.datamanager.persistence.type_converters.SpritesTypeConverter
import com.example.glea.data.datamanager.persistence.type_converters.StatsTypeConverter
import com.example.glea.data.datamanager.persistence.type_converters.TypesTypeConverter
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { Moshi.Builder().build() }
    single { SpritesTypeConverter(get()) }
    single { StatsTypeConverter(get()) }
    single { TypesTypeConverter(get()) }
    factory {
        PokemonDb.create(
            androidApplication(),
            false,
            SpritesTypeConverter(get()),
            StatsTypeConverter(get()),
            TypesTypeConverter(get())
        )
    }
}