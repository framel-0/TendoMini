package com.example.tendomini.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tendomini.data.repository.product.ProductRepository
import com.example.tendomini.ui.login.LoginViewModel

class ProductViewModelFactory(
    private val productRepository: ProductRepository,
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            return ProductViewModel(
                productRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}