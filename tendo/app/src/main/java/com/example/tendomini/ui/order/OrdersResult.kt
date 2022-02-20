package com.example.tendomini.ui.order

import com.example.tendomini.domain.models.Order

data class OrdersResult(
    val success: List<Order>? = null,
    val error: Int? = null
)
