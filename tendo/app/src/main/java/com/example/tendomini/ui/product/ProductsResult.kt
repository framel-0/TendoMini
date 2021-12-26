package com.example.tendomini.ui.product

import com.example.tendomini.data.models.Product

data class ProductsResult(
    val success: ArrayList<Product>? = null,
    val error: Int? = null
)
