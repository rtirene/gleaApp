package com.example.glea.data.datamanager.network.response.model

import com.example.glea.data.datamanager.network.response.model.Name
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

class RetrievedStat {

    @SerializedName("base_stat")
    var base_stat: Int? = null

    @SerializedName("effort")
    var effort: Int? = null

    @SerializedName("stat")
    var stat: Name? = null
}