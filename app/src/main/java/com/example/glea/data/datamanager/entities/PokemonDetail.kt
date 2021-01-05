package com.example.glea.data.datamanager.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "pokemon_detail")
@JsonClass(generateAdapter = true)
data class PokemonDetail(
    @PrimaryKey
    @NonNull
    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "id")
    @Json(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "sprites")
    @Json(name = "sprites")
    var sprites: Sprites? = null,

    @ColumnInfo(name = "stats")
    @Json(name = "stats")
    var stats: List<Stats>? = null,

    @ColumnInfo(name = "types")
    @Json(name = "types")
    var types: List<Type>? = null


)