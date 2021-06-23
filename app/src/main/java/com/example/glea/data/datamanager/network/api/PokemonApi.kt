package com.example.glea.data.datamanager.network.api

import com.example.glea.data.datamanager.entities.PokemonDetail
import com.example.glea.data.datamanager.entities.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApi {

    @GET(URL_POKEMON_LIST)
    suspend fun getPokemonList(@Query("limit") limit: Int? = 20,
                               @Query("offset") offset: Int? = 0): PokemonList

    @GET(URL_POKEMON_DETAIL)
    suspend fun getPokemonDetail(@Path("name") name: String?): PokemonDetail

    @GET
    suspend fun getPokemonDetailByUrl(@Url url: String): PokemonDetail?

    companion object {
        const val URL_POKEMON_LIST = "pokemon"
        const val URL_POKEMON_DETAIL = "pokemon/{name}"

    }
}
