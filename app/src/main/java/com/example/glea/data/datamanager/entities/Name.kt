package com.example.glea.data.datamanager.entities

import androidx.annotation.NonNull
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Name(
    @PrimaryKey
    @NonNull
    @SerializedName("name")
    val name: String
)