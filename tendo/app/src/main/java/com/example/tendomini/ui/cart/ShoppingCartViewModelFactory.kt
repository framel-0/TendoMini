package com.example.tendomini.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tendomini.data.repository.deliveryLocation.DeliveryLocationRepository

class ShoppingCartViewModelFactory(private val deliveryLocationRepository: DeliveryLocationRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppingCartViewModel::class.java)) {
            return ShoppingCartViewModel(
                deliveryLocationRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}