package com.example.tendomini.ui.order.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.domain.models.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderDetailViewModel @Inject constructor() : ViewModel() {

    private val _order = MutableLiveData<Order>()
    val order: LiveData<Order> = _order


    val orderCode = MutableLiveData<String>()
    val orderTimestamp = MutableLiveData<String>()
    val orderItems = MutableLiveData<String>()
    val orderDeliveryLocation = MutableLiveData<String>()
    val orderDescription = MutableLiveData<String>()

    fun setOrder(order: Order) {

        _order.postValue(order)

        orderCode.postValue(order.code)
        orderTimestamp.postValue(order.dateFmt)

        val sb = StringBuilder()

        for (str in order.items) {
            sb.append(str.toString())
            sb.append("\n")
        }

        val orderItms: String = sb.toString()

        orderItems.postValue(orderItms)
        orderDeliveryLocation.postValue(order.deliveryLocation.toString())

//        val desc = order.description
//        if (desc != null)
//            orderDescription.postValue(desc)
    }
}