package com.example.tendomini.data.datasource.local.mappers

import com.example.tendomini.data.datasource.local.entites.OrderEntity
import com.example.tendomini.domain.models.Order
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderEntityMapper @Inject constructor(
    private val deliveryLocationEntityMapper: DeliveryLocationEntityMapper,
    private val cartItemEntityMapper: CartItemEntityMapper
) : DomainModelMapper<OrderEntity, Order> {
    override fun mapToDomainModel(model: OrderEntity): Order {
        return Order(
            id = model.id,
            code = model.code,
            timestamp = model.timestamp,
            description = model.description,
            deliveryLocation = deliveryLocationEntityMapper.mapToDomainModel(model.deliveryLocation),
            items = cartItemEntityMapper.toDomainList(model.items),
        )
    }

    override fun mapFromDomainModel(domainModel: Order): OrderEntity {
        return OrderEntity(
            id = domainModel.id,
            code = domainModel.code,
            timestamp = domainModel.timestamp,
            description = domainModel.description,
            deliveryLocation = deliveryLocationEntityMapper.mapFromDomainModel(domainModel.deliveryLocation),
            items = cartItemEntityMapper.fromDomainList(domainModel.items),
        )
    }

    fun toDomainList(initial: List<OrderEntity>): List<Order> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Order>): List<OrderEntity> {
        return initial.map { mapFromDomainModel(it) }
    }
}