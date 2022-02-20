package com.example.tendomini.data.datasource.remote.product

import com.example.tendomini.data.datasource.remote.dtos.ProductDto

interface ProductDataSource {
    val products: ArrayList<ProductDto>

    fun productsCategory(categoryId: Int): ArrayList<ProductDto>

}