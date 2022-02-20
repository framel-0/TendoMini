package com.example.tendomini.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.R
import com.example.tendomini.data.Result
import com.example.tendomini.data.repository.cart.ShoppingCartRepository
import com.example.tendomini.data.repository.deliveryLocation.DeliveryLocationRepository
import com.example.tendomini.domain.models.CartItem
import com.example.tendomini.domain.models.DeliveryLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(private val deliveryLocationRepository: DeliveryLocationRepository) :
    ViewModel() {

    val cartItems: LiveData<MutableList<CartItem>> = ShoppingCartRepository.cartItems

    val cartTotalPrice: LiveData<Double> = ShoppingCartRepository.totalPrice
    val cartItemCount: LiveData<Int> = ShoppingCartRepository.totalQuantity

    private val _deliveryLocationsResult = MutableLiveData<DeliveryLocationsResult>()
    val deliveryLocationsResult: LiveData<DeliveryLocationsResult> = _deliveryLocationsResult

    private val _deliveryLocation = MutableLiveData<DeliveryLocation>()
    val deliveryLocation: LiveData<DeliveryLocation> = _deliveryLocation

    fun getDeliveryLocations() {
        val result = deliveryLocationRepository.getDeliveryLocations()
        if (result is Result.Success) {
            _deliveryLocationsResult.value =
                DeliveryLocationsResult(success = result.data)
        } else {
            _deliveryLocationsResult.value = DeliveryLocationsResult(error = R.string.login_failed)
        }

    }

    fun isCartEmpty(): Boolean {
        return cartItems.value.isNullOrEmpty()
    }

    val itemCount = MutableLiveData<String>()
    val totalPrice = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun removeCartItem(cartItemPos: CartItem) {
        ShoppingCartRepository.removeCartItem(cartItemPos)
    }

    fun increaseCartItemQuantity(itemPosition: CartItem) {
        ShoppingCartRepository.increaseCartItemQuantity(itemPosition)
    }

    fun decreaseCartItemQuantity(itemPosition: CartItem) {
        ShoppingCartRepository.decreaseCartItemQuantity(itemPosition)
    }

    fun removeALLCartItem() {
        ShoppingCartRepository.removeALLCartItem()
    }

    fun setDeliveryLocation(location: DeliveryLocation) {
        _deliveryLocation.postValue(location)
    }
}