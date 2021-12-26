package com.example.tendomini.data.repository.product

import com.example.tendomini.data.datasource.product.ProductDataSource
import com.example.tendomini.data.models.Product
import com.example.tendomini.data.models.Result

class ProductRepositoryImpl(
    private val dataSource: ProductDataSource
) : ProductRepository {


    override fun getProducts(): Result<ArrayList<Product>> {
        return dataSource.products
    }

    override fun getProductsCategory(categoryId: Int): Result<ArrayList<Product>> {
        return dataSource.productsCategory(categoryId)
    }


}