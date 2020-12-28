package com.example.glea.data.datamanager.model

import androidx.room.Entity
import com.example.glea.data.datamanager.model.Name
import com.google.gson.annotations.SerializedName


@Entity(tableName = "pokemon_list")
class PokemonListElement : Name() {
    @SerializedName("url")
    var url: String? = null
}