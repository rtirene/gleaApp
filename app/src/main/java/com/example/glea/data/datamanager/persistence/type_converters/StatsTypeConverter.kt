package com.example.glea.data.datamanager.persistence.type_converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.glea.data.datamanager.entities.Stats
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
class StatsTypeConverter(val moshi: Moshi) {
    private val statClass = Types.newParameterizedType(List::class.java, Stats::class.java)
    @TypeConverter
    fun fromStatsList(stats: List<Stats?>): String? {
        return moshi.adapter<List<Stats?>>(statClass).toJson(stats)
    }

    @TypeConverter
    fun toStatsList(stats: String?): List<Stats?> {
        return moshi.adapter<List<Stats?>>(statClass).fromJson(stats).orEmpty()
    }
}