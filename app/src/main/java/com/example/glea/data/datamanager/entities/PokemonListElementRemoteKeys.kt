package com.example.glea.data.datamanager.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "remote_keys")
data class PokemonListElementRemoteKeys (
    @PrimaryKey
    @NonNull
    val name: String,
    val prevKey: Int?,
    val nextKey: Int?
)