package com.example.tendomini.data.repository.productCategory

import com.example.tendomini.data.Result
import com.example.tendomini.domain.models.ProductCategory

interface ProductCategoryRepository {
    fun getCategories(): Result<List<ProductCategory>>
}