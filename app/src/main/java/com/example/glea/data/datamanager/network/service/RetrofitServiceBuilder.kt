package com.example.glea.data.datamanager.network.service

import com.example.glea.ConfigUtils
import com.example.glea.data.datamanager.network.api.PokemonApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitServiceBuilder {
    val api: PokemonApi

    val httpClient: OkHttpClient = OkHttpClient.Builder()
        .callTimeout(30L, TimeUnit.SECONDS)
        .connectTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(30L, TimeUnit.SECONDS)
        .writeTimeout(30L, TimeUnit.SECONDS)
        .build()

    fun createService(): PokemonApi {
        val vRetrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(ConfigUtils.apiBaseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return vRetrofit.create(PokemonApi::class.java)
    }

    init {
        api = createService()
    }
}