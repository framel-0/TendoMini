package com.example.tendomini.ui.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tendomini.data.repository.order.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val orderRepository: OrderRepository) :
    ViewModel() {

    fun deleteAllOrders() {
        viewModelScope.launch { orderRepository.deleteOrders() }
    }
}