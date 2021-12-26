package com.example.tendomini.ui.cart

import com.example.tendomini.data.models.DeliveryLocation

data class DeliveryLocationsResult(
    val success: ArrayList<DeliveryLocation>? = null,
    val error: Int? = null
)
