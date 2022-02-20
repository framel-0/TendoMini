package com.example.tendomini.data.datasource.remote.dtos

import com.google.gson.annotations.SerializedName


data class PaymentMethodDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)