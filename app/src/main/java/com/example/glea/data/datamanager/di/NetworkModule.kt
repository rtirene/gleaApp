package com.example.glea.data.datamanager.di

import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.network.api.PokemonDetailsApiHelperImpl
import com.example.glea.data.datamanager.network.api.PokemonListApiHelperImpl
import com.example.glea.data.datamanager.network.service.RetrofitServiceBuilder
import org.koin.dsl.module

val networkModule = module {
    single {
        RetrofitServiceBuilder
    }

    single {
        PokemonListApiHelperImpl(get())
    }

    single {
        PokemonDetailsApiHelperImpl(get())
    }
}