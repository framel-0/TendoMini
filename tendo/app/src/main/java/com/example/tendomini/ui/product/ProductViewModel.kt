package com.example.tendomini.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.R
import com.example.tendomini.data.models.Result
import com.example.tendomini.data.repository.product.ProductRepository

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    private val _productsResult = MutableLiveData<ProductsResult>()
    val productsResult: LiveData<ProductsResult> = _productsResult

    fun getProducts(categoryId: Int) {
        val result = if (categoryId == 0)
            productRepository.getProducts()
        else
            productRepository.getProductsCategory(categoryId)

        if (result is Result.Success) {
            _productsResult.value =
                ProductsResult(success = result.data)
        } else {
            _productsResult.value = ProductsResult(error = R.string.login_failed)
        }

    }
}