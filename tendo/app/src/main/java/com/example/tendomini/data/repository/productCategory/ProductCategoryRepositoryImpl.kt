package com.example.tendomini.data.repository.productCategory

import com.example.tendomini.data.Result
import com.example.tendomini.data.datasource.remote.mappers.ProductCategoryDtoMapper
import com.example.tendomini.data.datasource.remote.productCategory.ProductCategoryDataSource
import com.example.tendomini.domain.models.ProductCategory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductCategoryRepositoryImpl @Inject constructor(
    private val dataSource: ProductCategoryDataSource,
    private val dtoMapper: ProductCategoryDtoMapper,
) : ProductCategoryRepository {

    override fun getCategories(): Result<List<ProductCategory>> {
        try {

            val productCategoriesDto = dataSource.productCategories
            return Result.Success(dtoMapper.toDomainList(productCategoriesDto))

        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

}