package com.example.tendomini.data.datasource.local.mappers

import com.example.tendomini.data.datasource.local.entites.ProductCategoryEntity
import com.example.tendomini.data.datasource.remote.dtos.ProductCategoryDto
import com.example.tendomini.domain.models.ProductCategory
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductCategoryEntityMapper @Inject constructor() : DomainModelMapper<ProductCategoryEntity, ProductCategory> {
    override fun mapToDomainModel(model: ProductCategoryEntity): ProductCategory {
        return ProductCategory(
            id = model.id,
            name = model.name,
            description = model.description,
            image = model.image,
        )
    }

    override fun mapFromDomainModel(domainModel: ProductCategory): ProductCategoryEntity {
        return ProductCategoryEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            image = domainModel.image,
        )
    }
}