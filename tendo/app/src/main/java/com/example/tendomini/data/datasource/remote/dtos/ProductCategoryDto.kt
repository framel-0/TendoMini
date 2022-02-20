package com.example.tendomini.data.datasource.remote.dtos


import com.google.gson.annotations.SerializedName


data class ProductCategoryDto(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String?,

    val image: Int
)