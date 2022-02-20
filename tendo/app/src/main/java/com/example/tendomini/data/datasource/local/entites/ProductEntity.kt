package com.example.tendomini.data.datasource.local.entites


import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "products"
)
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val name: String,

    val description: String,

    val price: Double,

    @DrawableRes
    val images: List<Int>,

    @ColumnInfo(name = "category_id")
    val categoryId: Int

)


