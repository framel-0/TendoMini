package com.example.tendomini.ui.orderSummary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tendomini.R
import com.example.tendomini.data.Result
import com.example.tendomini.data.repository.cart.ShoppingCartRepository
import com.example.tendomini.data.repository.order.OrderRepository
import com.example.tendomini.domain.models.CartItem
import com.example.tendomini.domain.models.DeliveryLocation
import com.example.tendomini.domain.models.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class OrderSummaryViewModel @Inject constructor(private val orderRepository: OrderRepository) :
    ViewModel() {

    private val _orderResult = MutableLiveData<OrderResult>()
    val orderResult: LiveData<OrderResult> = _orderResult

    val cartItems: LiveData<MutableList<CartItem>> = ShoppingCartRepository.cartItems

    private val _deliveryLocation = MutableLiveData<DeliveryLocation>()
    val deliveryLocation: LiveData<DeliveryLocation> = _deliveryLocation

    val cartTotalPrice: LiveData<Double> = ShoppingCartRepository.totalPrice
    val cartItemCount: LiveData<Int> = ShoppingCartRepository.totalQuantity

    val itemCount = MutableLiveData<String>()
    val itemsCost = MutableLiveData<String>()
    val deliveryCost = MutableLiveData<String>()
    val totalCost = MutableLiveData<String>()
    val location = MutableLiveData<String>()
    val description = MutableLiveData<String?>()

    fun setDeliveryLocation(location: DeliveryLocation) {
        _deliveryLocation.postValue(location)
        this.location.postValue(location.name)
    }

    fun setDescription(desc: String?) {
        description.postValue(desc)
    }

    fun clearCart() {
        ShoppingCartRepository.removeALLCartItem()
    }

    fun saveOrder() {

        viewModelScope.launch {
            val dateNow = Date()

            val dateFormat = SimpleDateFormat(
                "HHmmss", Locale.getDefault()
            )

            val date = dateFormat.format(dateNow)

            val code = date.toString()

            val order = Order(
                id = 0,
                code = code,
                timestamp = dateNow,
                deliveryLocation = deliveryLocation.value!!,
                description = description.value,
                items = cartItems.value as List<CartItem>
            )

            val result = orderRepository.addOrder(order)

            if (result is Result.Success) {
                _orderResult.value =
                    OrderResult(success = result.data)
            } else {
                _orderResult.value = OrderResult(error = R.string.order_failed)
            }
        }
    }


}