package com.example.glea.data.datamanager.di

import com.example.glea.data.datamanager.persistence.PokemonDb
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    factory {
        PokemonDb.create(androidApplication(), false)
    }
}