package com.example.glea.data.datamanager.network.mappers

import com.example.glea.domain.models.Pokemon
import com.example.glea.data.datamanager.network.response.ResPokemonList

object PokemonListMapper : Mapper<ResPokemonList, List<Pokemon>?> {
    override fun map(input: ResPokemonList): List<Pokemon>? {
        return input.results?.map {
            Pokemon(it.name)
        }

    }

}