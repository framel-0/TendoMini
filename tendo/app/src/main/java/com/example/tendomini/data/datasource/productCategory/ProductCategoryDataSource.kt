package com.example.tendomini.data.datasource.productCategory

import com.example.tendomini.data.models.ProductCategory
import com.example.tendomini.data.models.Result

interface ProductCategoryDataSource {
    val productCategories: Result<ArrayList<ProductCategory>>

}