package com.example.tendomini.data.datasource.remote.mappers

import com.example.tendomini.data.datasource.remote.dtos.ProductCategoryDto
import com.example.tendomini.domain.models.ProductCategory
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductCategoryDtoMapper @Inject constructor() : DomainModelMapper<ProductCategoryDto, ProductCategory> {
    override fun mapToDomainModel(model: ProductCategoryDto): ProductCategory {
        return ProductCategory(
            id = model.id,
            name = model.name,
            description = model.description,
            image = model.image,
        )
    }

    override fun mapFromDomainModel(domainModel: ProductCategory): ProductCategoryDto {
        return ProductCategoryDto(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            image = domainModel.image,
        )
    }

    fun toDomainList(initial: List<ProductCategoryDto>): List<ProductCategory>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<ProductCategory>): List<ProductCategoryDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}