package com.example.glea.data.datamanager.network.mappers

import com.example.glea.domain.models.Pokemon
import com.example.glea.data.datamanager.model.PokemonList

object PokemonListMapper : Mapper<PokemonList, List<Pokemon>?> {
    override fun map(input: PokemonList): List<Pokemon>? {
        return input.results?.map {
            Pokemon(it.name)
        }

    }

}