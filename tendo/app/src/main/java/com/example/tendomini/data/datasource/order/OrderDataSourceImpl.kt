package com.example.tendomini.data.datasource.order

import com.example.tendomini.data.db.OrderDao
import com.example.tendomini.data.models.Order
import com.example.tendomini.data.models.Result

class OrderDataSourceImpl(private val orderDao: OrderDao) : OrderDataSource {
    override val orders: Result<ArrayList<Order>>
        get() = Result.Success(orderDao.getOrders as ArrayList<Order>)

    override fun addOrder(order: Order): Result<Long> {
        val res = orderDao.addOrder(order)

        return Result.Success(res)
    }

    override fun deleteOrders() {
        orderDao.deleteAll()
    }

}