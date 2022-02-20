package com.example.tendomini.data.repository.order

import com.example.tendomini.data.Result
import com.example.tendomini.domain.models.Order

interface OrderRepository {
    fun getOrders(): Result<List<Order>>

    suspend fun addOrder(order: Order): Result<Long>

    suspend fun deleteOrders()
}