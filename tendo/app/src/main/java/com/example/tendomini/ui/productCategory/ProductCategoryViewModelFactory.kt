package com.example.tendomini.ui.productCategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tendomini.data.repository.productCategory.ProductCategoryRepository

class ProductCategoryViewModelFactory(private val productCategoryRepository: ProductCategoryRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductCategoryViewModel::class.java)) {
            return ProductCategoryViewModel(
                productCategoryRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}