package com.example.tendomini.ui.productCategory

import com.example.tendomini.data.models.ProductCategory

data class ProductCategoriesResult(
    val success: ArrayList<ProductCategory>? = null,
    val error: Int? = null
)
