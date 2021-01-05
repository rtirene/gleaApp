package com.example.glea.data.datamanager.di

import com.example.glea.data.datamanager.mappers.PokemonDetailMapper
import org.koin.dsl.module

val mapperModule = module {
    single {
        PokemonDetailMapper()
    }
}