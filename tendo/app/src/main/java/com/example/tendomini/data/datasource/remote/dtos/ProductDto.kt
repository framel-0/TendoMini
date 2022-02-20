package com.example.tendomini.data.datasource.remote.dtos


import com.google.gson.annotations.SerializedName


data class ProductDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("price")
    val price: Double,

    val images: List<Int>,

    @SerializedName("categoryId")
    val categoryId: Int
)
