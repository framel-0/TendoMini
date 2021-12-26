package com.example.tendomini.ui.product.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.data.models.CartItem
import com.example.tendomini.data.models.Product
import com.example.tendomini.data.repository.cart.ShoppingCartRepository

class ProductDetailViewModel : ViewModel() {
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