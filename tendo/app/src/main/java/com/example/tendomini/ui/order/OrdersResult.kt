package com.example.tendomini.ui.order

import com.example.tendomini.data.models.Order

data class OrdersResult(
    val success: ArrayList<Order>? = null,
    val error: Int? = null
)
