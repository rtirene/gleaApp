package com.example.glea.data.datamanager.di

import androidx.room.TypeConverter
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.datamanager.persistence.type_converters.SpritesTypeConverter
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    factory {
        PokemonDb.create(androidApplication(), false)
    }
}