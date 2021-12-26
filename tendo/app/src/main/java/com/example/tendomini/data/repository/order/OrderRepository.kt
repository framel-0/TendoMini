package com.example.tendomini.data.repository.order

import com.example.tendomini.data.models.Order
import com.example.tendomini.data.models.Result

interface OrderRepository {
    fun getOrders(): Result<ArrayList<Order>>

    fun addOrder(order: Order): Result<Long>

    fun deleteOrders()
}