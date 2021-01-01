package com.example.glea.data.datamanager.entities

import android.net.Uri
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.glea.ConfigUtils
import com.google.gson.annotations.SerializedName


@Entity(tableName = "pokemon_list")
class PokemonListElement {
    @PrimaryKey
    @NonNull
    @SerializedName("name")
    lateinit var name: String

    @SerializedName("url")
    var url: String? = null

    fun getUrlFrontImage(): String {
        return ConfigUtils.listImagesBaseUrl + Uri.parse(url).lastPathSegment + ".png"
    }
}


