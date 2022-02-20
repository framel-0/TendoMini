package com.example.tendomini.data.repository.product

import com.example.tendomini.data.Result
import com.example.tendomini.data.datasource.remote.mappers.ProductDtoMapper
import com.example.tendomini.data.datasource.remote.product.ProductDataSource
import com.example.tendomini.domain.models.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource,
    private val dtoMapper: ProductDtoMapper
) : ProductRepository {

    override fun getProducts(): Result<List<Product>> {
        try {

            val productsDto = dataSource.products
            return Result.Success(dtoMapper.toDomainList(productsDto))

        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

    override fun getProductsCategory(categoryId: Int): Result<List<Product>> {
        try {

            val productsDto = dataSource.productsCategory(categoryId)
            return Result.Success(dtoMapper.toDomainList(productsDto))

        } catch (e: Exception) {
            return Result.Error(e)
        }
    }


}