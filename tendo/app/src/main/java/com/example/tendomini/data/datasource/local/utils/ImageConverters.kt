package com.example.tendomini.data.datasource.local.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class ImageConverters {
    @TypeConverter
    fun toImages(value: String?) =
        Gson().fromJson(value, Array<Int>::class.java).toList()

    @TypeConverter
    fun fromImages(value: List<Int>?) =
        Gson().toJson(value)
}
