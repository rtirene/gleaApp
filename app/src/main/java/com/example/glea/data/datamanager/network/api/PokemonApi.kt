package com.example.glea.datamanager.network.api

import com.example.glea.data.datamanager.network.response.ResPokemon
import com.example.glea.data.datamanager.network.response.ResPokemonList
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET(URL_POKEMON_LIST)
    suspend fun getPokemonList(): ResPokemonList

    @GET(URL_POKEMON_DETAIL)
    suspend fun getPokemonDetail(@Path("name") name: String?): ResPokemon

    companion object {
        const val URL_POKEMON_LIST = "pokemon"
        const val URL_POKEMON_DETAIL = "pokemon/{name}"
    }
}
