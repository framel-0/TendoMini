package com.example.tendomini.data.datasource.local.order

import androidx.annotation.WorkerThread
import com.example.tendomini.data.datasource.local.db.OrderDao
import com.example.tendomini.data.datasource.local.entites.OrderEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderDataSourceImpl @Inject constructor(private val orderDao: OrderDao) : OrderDataSource {

    override val orders: List<OrderEntity>
        get() = orderDao.getOrders

    @WorkerThread
    override suspend fun addOrder(order: OrderEntity): Long {
        return orderDao.addOrder(order)
    }

    @WorkerThread
    override suspend fun deleteOrders() {
        orderDao.deleteAll()
    }

}