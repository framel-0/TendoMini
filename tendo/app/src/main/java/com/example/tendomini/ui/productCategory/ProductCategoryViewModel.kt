package com.example.tendomini.ui.productCategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.R
import com.example.tendomini.data.Result
import com.example.tendomini.data.repository.productCategory.ProductCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductCategoryViewModel @Inject constructor(private val productCategoryRepository: ProductCategoryRepository) :
    ViewModel() {

    private val _productCategoriesResult = MutableLiveData<ProductCategoriesResult>()
    val productCategoriesResult: LiveData<ProductCategoriesResult> = _productCategoriesResult

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