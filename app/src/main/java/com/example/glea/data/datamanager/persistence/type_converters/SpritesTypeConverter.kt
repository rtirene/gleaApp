package com.example.glea.data.datamanager.persistence.type_converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.glea.data.datamanager.entities.Sprites
import com.example.glea.data.datamanager.persistence.PokemonDb
import com.squareup.moshi.Moshi
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject

@ProvidedTypeConverter
class SpritesTypeConverter(val moshi: Moshi) {
    @TypeConverter
    fun fromSprites(sprites: Sprites?): String? {
        return moshi.adapter(Sprites::class.java).toJson(sprites)
    }

    @TypeConverter
    fun toSprites(sprites: String?): Sprites? {
        return moshi.adapter(Sprites::class.java).fromJson(sprites)
    }
}