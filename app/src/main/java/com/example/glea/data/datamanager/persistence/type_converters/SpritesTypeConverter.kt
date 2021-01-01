package com.example.glea.data.datamanager.persistence.type_converters

import androidx.room.TypeConverter
import com.example.glea.data.datamanager.entities.Sprites
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpritesTypeConverter {
    @TypeConverter
    fun fromSprites(sprites: Sprites?): String? {
        val type = object : TypeToken<Sprites>() {}.type
        return Gson().toJson(sprites, type)
    }

    @TypeConverter
    fun toSprites(sprites: String?): Sprites? {
        val type = object : TypeToken<Sprites>() {}.type
        return Gson().fromJson<Sprites>(sprites, type)
    }
}