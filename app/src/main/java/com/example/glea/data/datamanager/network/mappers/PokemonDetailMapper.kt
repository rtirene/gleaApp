package com.example.glea.datamanager.network.mappers

import com.example.glea.domain.models.Images
import com.example.glea.domain.models.Pokemon
import com.example.glea.domain.models.Stat
import com.example.glea.domain.models.Type
import com.example.glea.data.datamanager.network.response.ResPokemon

class PokemonDetailMapper : Mapper<ResPokemon, Pokemon> {
    override fun map(input: ResPokemon): Pokemon {

        return Pokemon(input.name,
            Images(input.images?.frontImage, input.images?.backImage),
            input.stats?.map {
                Stat(it.stat?.name, it.statValue, it.effortPoints)
            },
            input.types?.map {
                Type(it.typeOrder, it.typeDetails?.name)
            }
        )
    }


}