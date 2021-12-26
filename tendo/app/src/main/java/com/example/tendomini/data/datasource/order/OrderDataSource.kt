package com.example.tendomini.data.datasource.order

import com.example.tendomini.data.models.Order
import com.example.tendomini.data.models.Result

interface OrderDataSource {
    val orders: Result<ArrayList<Order>>

    fun addOrder(order: Order) : Result<Long>

    fun deleteOrders()
}