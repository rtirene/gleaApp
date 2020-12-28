package com.example.glea.data.datamanager.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon_detail")
class PokemonDetail : Name() {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName( "sprites")
    var sprites: Sprites? = null

    @SerializedName("stats")
    var stats: List<Stats>? = null

    @SerializedName("types")
    var types: List<Type>? = null
}