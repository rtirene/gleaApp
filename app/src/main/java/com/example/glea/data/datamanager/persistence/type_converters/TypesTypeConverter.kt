package com.example.glea.data.datamanager.persistence.type_converters

import androidx.room.TypeConverter
import com.example.glea.data.datamanager.entities.Type
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypesTypeConverter {
    @TypeConverter
    fun fromTypeList(types: List<Type?>?): String? {
        val type = object : TypeToken<List<Type>>() {}.type
        return Gson().toJson(types, type)
    }

    @TypeConverter
    fun toTypeList(types: String?): List<Type>? {
        val type = object : TypeToken<List<Type>>() {}.type
        return Gson().fromJson<List<Type>>(types, type)
    }
}