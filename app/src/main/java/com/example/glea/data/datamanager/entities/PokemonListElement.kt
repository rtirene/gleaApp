package com.example.glea.data.datamanager.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@Entity(tableName = "pokemon_list")
@JsonClass(generateAdapter = true)
class PokemonListElement {
    @PrimaryKey
    @NonNull
    @Json(name = "name")
    lateinit var name: String

    @Json(name = "url")
    var url: String? = null
}


