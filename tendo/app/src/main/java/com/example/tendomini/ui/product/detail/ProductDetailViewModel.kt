package com.example.tendomini.ui.product.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.data.repository.cart.ShoppingCartRepository
import com.example.tendomini.domain.models.CartItem
import com.example.tendomini.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor() : ViewModel() {
    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    val productName = MutableLiveData<String>()
    val productPrice = MutableLiveData<String>()
    val productDescription = MutableLiveData<String>()

    val productPriceEdt = MutableLiveData<String>()

    fun setProduct(product: Product) {
        _product.postValue(product)

        productName.postValue(product.name)
        productPrice.postValue(product.displayPrice)
        productPriceEdt.postValue(product.displayPrice)
        productDescription.postValue(product.description)
    }

    fun addCartItem() {
        val product = product.value!!
        val cartItem = CartItem(product = product)
        cartItem.let { ShoppingCartRepository.addCartItem(it) }
    }

}