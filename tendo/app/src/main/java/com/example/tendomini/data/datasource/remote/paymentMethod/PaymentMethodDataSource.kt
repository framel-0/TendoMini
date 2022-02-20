package com.example.tendomini.data.datasource.remote.paymentMethod

import com.example.tendomini.data.datasource.remote.dtos.PaymentMethodDto

interface PaymentMethodDataSource {

    val paymentMethods: ArrayList<PaymentMethodDto>

}