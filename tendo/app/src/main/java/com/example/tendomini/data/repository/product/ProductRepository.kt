package com.example.tendomini.data.repository.product

import com.example.tendomini.data.models.Product
import com.example.tendomini.data.models.Result

interface ProductRepository {
    fun getProducts(): Result<ArrayList<Product>>
    fun getProductsCategory(categoryId: Int): Result<ArrayList<Product>>

}