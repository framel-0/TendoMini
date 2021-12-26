package com.example.tendomini.ui

import androidx.lifecycle.ViewModel
import com.example.tendomini.data.repository.order.OrderRepository

class SharedViewModel(private val orderRepository: OrderRepository) : ViewModel() {

    fun deleteAllOrders() {
        orderRepository.deleteOrders()
    }
}