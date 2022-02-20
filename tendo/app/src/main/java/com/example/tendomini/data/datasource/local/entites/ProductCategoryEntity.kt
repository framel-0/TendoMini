package com.example.tendomini.data.datasource.local.entites


import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "product_categories"
)
data class ProductCategoryEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val name: String,

    val description: String?,

    @DrawableRes
    val image: Int
)