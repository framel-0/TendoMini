package com.example.tendomini.data.datasource.local.mappers

import com.example.tendomini.data.datasource.local.entites.CartItemEntity
import com.example.tendomini.domain.models.CartItem
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartItemEntityMapper @Inject constructor(private val productEntityMapper: ProductEntityMapper) :
    DomainModelMapper<CartItemEntity, CartItem> {
    override fun mapToDomainModel(model: CartItemEntity): CartItem {
        return CartItem(
            id = model.id,
            product = productEntityMapper.mapToDomainModel(model.product),
            quantity = model.quantity,
        )
    }

    override fun mapFromDomainModel(domainModel: CartItem): CartItemEntity {
        return CartItemEntity(
            id = domainModel.id,
            product = productEntityMapper.mapFromDomainModel(domainModel.product),
            quantity = domainModel.quantity,
        )
    }

    fun toDomainList(initial: List<CartItemEntity>): List<CartItem> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<CartItem>): List<CartItemEntity> {
        return initial.map { mapFromDomainModel(it) }
    }
}