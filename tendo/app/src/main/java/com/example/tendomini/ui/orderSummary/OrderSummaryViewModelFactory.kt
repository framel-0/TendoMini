package com.example.tendomini.ui.orderSummary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tendomini.data.repository.order.OrderRepository

class OrderSummaryViewModelFactory(private val orderRepository: OrderRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderSummaryViewModel::class.java)) {
            return OrderSummaryViewModel(
                orderRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}