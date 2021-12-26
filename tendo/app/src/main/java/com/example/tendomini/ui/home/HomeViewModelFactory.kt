package com.example.tendomini.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tendomini.data.repository.product.ProductRepository
import com.example.tendomini.data.repository.productCategory.ProductCategoryRepository
import com.example.tendomini.data.repository.user.UserRepository

class HomeViewModelFactory(
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository,
    private val productCategoryRepository: ProductCategoryRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(
                userRepository, productRepository, productCategoryRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}