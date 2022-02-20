package com.example.tendomini.data.repository.product

import com.example.tendomini.data.Result
import com.example.tendomini.domain.models.Product

interface ProductRepository {
    fun getProducts(): Result<List<Product>>
    fun getProductsCategory(categoryId: Int): Result<List<Product>>

}