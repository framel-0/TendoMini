package com.example.tendomini.domain.models


import androidx.annotation.DrawableRes


data class ProductCategory(
    val id: Int,
    val name: String,
    val description: String?,
    @DrawableRes
    val image: Int
)