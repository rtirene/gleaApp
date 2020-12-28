package com.example.glea.data.datamanager.model

import com.example.glea.data.datamanager.model.Name
import com.google.gson.annotations.SerializedName

class Stats {

    @SerializedName("base_stat")
    var base_stat: Int? = null

    @SerializedName("effort")
    var effort: Int? = null

    @SerializedName("stat")
    var stat: Name? = null
}