package com.example.tendomini.data.repository.productCategory

import com.example.tendomini.data.models.ProductCategory
import com.example.tendomini.data.models.Result

interface ProductCategoryRepository {
    fun getCategories(): Result<ArrayList<ProductCategory>>
}