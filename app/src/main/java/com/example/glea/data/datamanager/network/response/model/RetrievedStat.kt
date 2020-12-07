package com.example.glea.datamanager.network.response.model

import com.squareup.moshi.Json

class RetrievedStat {

    @Json(name = "base_stat")
    var statValue: Int? = null

    @Json(name = "effort")
    var effortPoints: Int? = null

    @Json(name = "stat")
    var stat: Name? = null
}