package com.example.tendomini.data.datasource.remote.productCategory

import com.example.tendomini.data.datasource.remote.dtos.ProductCategoryDto

interface ProductCategoryDataSource {
    val productCategories: ArrayList<ProductCategoryDto>

}