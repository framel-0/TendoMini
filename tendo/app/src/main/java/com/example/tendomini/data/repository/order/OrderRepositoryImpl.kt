package com.example.tendomini.data.repository.order

import com.example.tendomini.data.Result
import com.example.tendomini.data.datasource.local.mappers.OrderEntityMapper
import com.example.tendomini.data.datasource.local.order.OrderDataSource
import com.example.tendomini.domain.models.Order
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderRepositoryImpl @Inject constructor(
    private val dataSource: OrderDataSource,
    private val entityMapper: OrderEntityMapper
) :
    OrderRepository {
    override fun getOrders(): Result<List<Order>> {
        try {

            val ordersEntity = dataSource.orders
            return Result.Success(entityMapper.toDomainList(ordersEntity))

        } catch (e: Exception) {
            return Result.Error(e)
        }

    }

    override suspend fun addOrder(order: Order): Result<Long> {
        try {

            val result = dataSource.addOrder(entityMapper.mapFromDomainModel(order))
            return Result.Success(result)

        } catch (e: Exception) {
            return Result.Error(e)
        }

    }

    override suspend fun deleteOrders() {
        dataSource.deleteOrders()
    }
}