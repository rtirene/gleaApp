package com.example.glea.data.datamanager.persistence.type_converters

import androidx.room.TypeConverter
import com.example.glea.data.datamanager.entities.Type
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class TypesTypeConverter {
    private val moshi = Moshi.Builder().build()
    private val typesClass = Types.newParameterizedType(List::class.java, Type::class.java)

    @TypeConverter
    fun fromTypeList(types: List<Type?>?): String? {
        return moshi.adapter<List<Type?>>(typesClass).toJson(types)
    }

    @TypeConverter
    fun toTypeList(types: String?): List<Type>? {
        return moshi.adapter<List<Type>>(typesClass).fromJson(types).orEmpty()
    }
}