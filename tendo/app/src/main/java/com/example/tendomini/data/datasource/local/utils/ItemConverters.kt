package com.example.tendomini.data.datasource.local.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.tendomini.data.datasource.local.entites.CartItemEntity
import com.google.gson.Gson

@ProvidedTypeConverter
class ItemConverters {
    @TypeConverter
    fun toItems(value: String?) =
        Gson().fromJson(value, Array<CartItemEntity>::class.java).toList()

    @TypeConverter
    fun fromItems(value: List<CartItemEntity>?) =
        Gson().toJson(value)
}