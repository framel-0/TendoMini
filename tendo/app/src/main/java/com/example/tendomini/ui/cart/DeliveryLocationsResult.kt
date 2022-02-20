package com.example.tendomini.ui.cart

import com.example.tendomini.domain.models.DeliveryLocation

data class DeliveryLocationsResult(
    val success: List<DeliveryLocation>? = null,
    val error: Int? = null
)
