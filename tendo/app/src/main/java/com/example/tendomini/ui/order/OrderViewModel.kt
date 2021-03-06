package com.example.tendomini.ui.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.R
import com.example.tendomini.data.Result
import com.example.tendomini.data.repository.order.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val orderRepository: OrderRepository) :
    ViewModel() {
    private val _ordersResult = MutableLiveData<OrdersResult>()
    val ordersResult: LiveData<OrdersResult> = _ordersResult

    fun getOrders() {
        val result = orderRepository.getOrders()

        if (result is Result.Success) {
            _ordersResult.value =
                OrdersResult(success = result.data)
        } else {
            _ordersResult.value = OrdersResult(error = R.string.login_failed)
        }

    }
}