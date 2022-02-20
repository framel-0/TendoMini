package com.example.tendomini.data.datasource.remote.dtos

import com.google.gson.annotations.SerializedName


data class DeliveryLocationDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: Double,
)