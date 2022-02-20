package com.example.tendomini.data.datasource.remote.mappers

import com.example.tendomini.data.datasource.remote.dtos.ProductDto
import com.example.tendomini.domain.models.Product
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDtoMapper @Inject constructor() : DomainModelMapper<ProductDto, Product> {
    override fun mapToDomainModel(model: ProductDto): Product {
        return Product(
            id = model.id,
            name = model.name,
            description = model.description,
            price = model.price,
            images = model.images,
            categoryId = model.categoryId,
        )
    }

    override fun mapFromDomainModel(domainModel: Product): ProductDto {
        return ProductDto(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            price = domainModel.price,
            images = domainModel.images,
            categoryId = domainModel.categoryId,
        )
    }

    fun toDomainList(initial: List<ProductDto>): List<Product> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Product>): List<ProductDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}