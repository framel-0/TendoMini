package com.example.tendomini.data.datasource.local.order

import com.example.tendomini.data.datasource.local.entites.OrderEntity
import com.example.tendomini.data.Result

interface OrderDataSource {


    val orders: List<OrderEntity>

    suspend fun addOrder(order: OrderEntity) : Long

    suspend fun deleteOrders()
}