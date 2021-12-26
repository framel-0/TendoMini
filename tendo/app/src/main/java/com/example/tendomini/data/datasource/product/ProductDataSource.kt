package com.example.tendomini.data.datasource.product

import com.example.tendomini.data.models.Product
import com.example.tendomini.data.models.Result

interface ProductDataSource {
    val products: Result<ArrayList<Product>>

    fun productsCategory(categoryId: Int): Result<ArrayList<Product>>

}