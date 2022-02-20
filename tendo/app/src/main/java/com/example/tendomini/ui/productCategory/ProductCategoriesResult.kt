package com.example.tendomini.ui.productCategory

import com.example.tendomini.domain.models.ProductCategory

data class ProductCategoriesResult(
    val success: List<ProductCategory>? = null,
    val error: Int? = null
)
