package com.example.tendomini.data.repository.order

import com.example.tendomini.data.datasource.order.OrderDataSource
import com.example.tendomini.data.models.Order
import com.example.tendomini.data.models.Result

class OrderRepositoryImpl(private val dataSource: OrderDataSource) : OrderRepository {
    override fun getOrders(): Result<ArrayList<Order>> {
        return dataSource.orders
    }

    override fun addOrder(order: Order): Result<Long> {
        return dataSource.addOrder(order)
    }

    override fun deleteOrders() {
        dataSource.deleteOrders()
    }
}