package com.example.glea.data.datamanager.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon_detail")
data class PokemonDetail(
    @PrimaryKey
    @NonNull
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int? = null,

    @ColumnInfo(name = "sprites")
    @SerializedName("sprites")
    var sprites: Sprites? = null,

    @ColumnInfo(name = "stats")
    @SerializedName("stats")
    var stats: List<Stats>? = null,

    @ColumnInfo(name = "types")
    @SerializedName("types")
    var types: List<Type>? = null


)