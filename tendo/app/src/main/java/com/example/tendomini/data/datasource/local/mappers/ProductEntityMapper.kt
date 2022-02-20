package com.example.tendomini.data.datasource.local.mappers

import com.example.tendomini.data.datasource.local.entites.ProductEntity
import com.example.tendomini.domain.models.Product
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductEntityMapper @Inject constructor() : DomainModelMapper<ProductEntity, Product> {
    override fun mapToDomainModel(model: ProductEntity): Product {
        return Product(
            id = model.id,
            name = model.name,
            description = model.description,
            price = model.price,
            images = model.images,
            categoryId = model.categoryId,
        )
    }

    override fun mapFromDomainModel(domainModel: Product): ProductEntity {
        return ProductEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            price = domainModel.price,
            images = domainModel.images,
            categoryId = domainModel.categoryId,
        )
    }
}