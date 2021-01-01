package com.example.glea.data.datamanager.mappers

import com.example.glea.domain.models.Images
import com.example.glea.domain.models.Pokemon
import com.example.glea.domain.models.Stat
import com.example.glea.domain.models.Type
import com.example.glea.data.datamanager.entities.PokemonDetail

class PokemonDetailMapper : Mapper<PokemonDetail?, Pokemon?> {
    override fun map(input: PokemonDetail?): Pokemon {

        return Pokemon(input?.name,
            Images(input?.sprites?.front_default, input?.sprites?.back_default),
            input?.stats?.map {
                Stat(it.stat?.name, it.base_stat, it.effort)
            },
            input?.types?.map {
                Type(it.typeOrder, it.typeDetails?.name)
            }
        )
    }
}