package com.example.tendomini.ui.product

import com.example.tendomini.domain.models.Product

data class ProductsResult(
    val success: List<Product>? = null,
    val error: Int? = null
)
