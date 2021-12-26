package com.example.tendomini.data.repository.productCategory

import com.example.tendomini.data.datasource.productCategory.ProductCategoryDataSource
import com.example.tendomini.data.models.ProductCategory
import com.example.tendomini.data.models.Result

class ProductCategoryRepositoryImpl(
    private val dataSource: ProductCategoryDataSource
) : ProductCategoryRepository {


    override fun getCategories(): Result<ArrayList<ProductCategory>> {
        return dataSource.productCategories
    }


}