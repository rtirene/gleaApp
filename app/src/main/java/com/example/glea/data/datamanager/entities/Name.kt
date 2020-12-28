package com.example.glea.data.datamanager.model

import androidx.annotation.NonNull
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

open class Name {
    @PrimaryKey
    @NonNull
    @SerializedName("name")
    var name: String? = null
}