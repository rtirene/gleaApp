package com.example.glea.data.datamanager.model

import com.google.gson.annotations.SerializedName

class Type {
    @SerializedName("slot")
    var typeOrder: Int? = null

    @SerializedName("type")
    var typeDetails: Name? = null
}