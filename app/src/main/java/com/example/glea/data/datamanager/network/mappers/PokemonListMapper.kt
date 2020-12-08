package com.example.glea.datamanager.network.mappers

import com.example.glea.domain.models.Pokemon
import com.example.glea.data.datamanager.network.response.ResPokemonList

object PokemonListMapper : Mapper<ResPokemonList, List<Pokemon>?> {
    override fun map(input: ResPokemonList): List<Pokemon>? {
        return input.pokemonList?.map {
            Pokemon(it.name)
        }

    }

}