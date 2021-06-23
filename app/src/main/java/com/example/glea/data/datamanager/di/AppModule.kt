package com.example.glea.data.datamanager.di

import androidx.paging.ExperimentalPagingApi
import com.example.glea.data.datamanager.network.api.PokemonDetailApiHelper
import com.example.glea.data.datamanager.network.api.PokemonDetailsApiHelperImpl
import com.example.glea.data.datamanager.network.api.PokemonListApiHelper
import com.example.glea.data.datamanager.network.api.PokemonListApiHelperImpl
import com.example.glea.data.datamanager.network.service.RetrofitServiceBuilder
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.example.glea.data.datamanager.persistence.type_converters.SpritesTypeConverter
import com.example.glea.data.datamanager.persistence.type_converters.StatsTypeConverter
import com.example.glea.data.datamanager.persistence.type_converters.TypesTypeConverter
import com.example.glea.data.repository.PokemonListRepository
import com.example.glea.data.repository.PokemonListRepositoryImpl
import com.example.glea.domain.usecases.GetPokemonList
import com.example.glea.presentation.view_model.PokemonListViewModel
import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val POKEMON_LIST_VIEW_MODEL = "PokemonListViewModel"
const val POKEMON_LIST_REPOSITORY = "PokemonListRepository"
const val POKEMON_LIST_USECASE = "PokemonListUsecase"
const val POKEMON_LIST_APIHELPER = "PokemonListApiHelper"
const val POKEMON_DETAIL_APIHELPER = "PokemonDetailApiHelper"
const val POKEMON_DB = "PokemonDB"

@ExperimentalCoroutinesApi
@ExperimentalPagingApi
val appModule = module {
    single {
        RetrofitServiceBuilder
    }

    single<PokemonListApiHelper>(named(POKEMON_LIST_APIHELPER)){
        PokemonListApiHelperImpl(get())
    }

    single<PokemonDetailApiHelper>(named(POKEMON_DETAIL_APIHELPER)){
        PokemonDetailsApiHelperImpl(get())
    }

    single { Moshi.Builder().build() }
    single { SpritesTypeConverter(get()) }
    single { StatsTypeConverter(get()) }
    single { TypesTypeConverter(get()) }
    single(named(POKEMON_DB)){
        PokemonDb.create(
            androidApplication(),
            false,
            SpritesTypeConverter(get()),
            StatsTypeConverter(get()),
            TypesTypeConverter(get())
        )
    }

    single<PokemonListRepository>(named(POKEMON_LIST_REPOSITORY)) {
        PokemonListRepositoryImpl(
            get(named(POKEMON_LIST_APIHELPER)),
            get(named(POKEMON_DETAIL_APIHELPER)),
            get(named(POKEMON_DB))
        )
    }

    factory(named(POKEMON_LIST_USECASE)) {
        GetPokemonList(
            get(named(POKEMON_LIST_REPOSITORY))
        )
    }

    viewModel(named(POKEMON_LIST_VIEW_MODEL)) {
        PokemonListViewModel(get(named(POKEMON_LIST_USECASE)))
    }
}