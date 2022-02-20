package com.example.tendomini.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.R
import com.example.tendomini.data.Result
import com.example.tendomini.data.repository.product.ProductRepository
import com.example.tendomini.data.repository.productCategory.ProductCategoryRepository
import com.example.tendomini.data.repository.user.UserRepository
import com.example.tendomini.ui.login.AuthenticationState
import com.example.tendomini.ui.product.ProductsResult
import com.example.tendomini.ui.productCategory.ProductCategoriesResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository,
    private val productCategoryRepository: ProductCategoryRepository
) : ViewModel() {

    private val _authenticationState = MutableLiveData<AuthenticationState>()
    val authenticationState: LiveData<AuthenticationState> = _authenticationState

    private val _productCategoriesResult = MutableLiveData<ProductCategoriesResult>()
    val productCategoriesResult: LiveData<ProductCategoriesResult> = _productCategoriesResult

    private val _productsResult = MutableLiveData<ProductsResult>()
    val productsResult: LiveData<ProductsResult> = _productsResult

    init {

        if (userRepository.isLoggedIn)
        // In this example, the user is always unauthenticated when MainActivity is launched
            _authenticationState.value = AuthenticationState.AUTHENTICATED
        else
            _authenticationState.value = AuthenticationState.UNAUTHENTICATED


    }

    fun getProducts() {
        val result = productRepository.getProducts()
        if (result is Result.Success) {
            _productsResult.value =
                ProductsResult(success = result.data)
        } else {
            _productsResult.value = ProductsResult(error = R.string.login_failed)
        }

    }

    fun getProductCategories() {
        val result = productCategoryRepository.getCategories()
        if (result is Result.Success) {
            _productCategoriesResult.value =
                ProductCategoriesResult(success = result.data)
        } else {
            _productCategoriesResult.value = ProductCategoriesResult(error = R.string.login_failed)
        }

    }

}