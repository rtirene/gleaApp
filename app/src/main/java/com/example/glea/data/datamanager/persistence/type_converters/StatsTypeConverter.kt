package com.example.glea.data.datamanager.persistence.type_converters

import androidx.room.TypeConverter
import com.example.glea.data.datamanager.entities.Stats
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StatsTypeConverter {
    @TypeConverter
    fun fromStatsList(stats: List<Stats?>?): String? {
        val type = object : TypeToken<List<Stats>>() {}.type
        return Gson().toJson(stats, type)
    }

    @TypeConverter
    fun toStatsList(stats: String?): List<Stats>? {
        val type = object : TypeToken<List<Stats>>() {}.type
        return Gson().fromJson<List<Stats>>(stats, type)
    }
}