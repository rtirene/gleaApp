package com.example.glea.data.datamanager.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

class Sprites {
    @SerializedName("front_shiny")
    var front_shiny: String? = null

    @SerializedName("back_shiny")
    var back_shiny: String? = null
}