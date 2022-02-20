package com.example.tendomini.data.datasource.remote.paymentMethod

import com.example.tendomini.data.datasource.remote.dtos.PaymentMethodDto

class PaymentMethodDataSourceImpl :
    PaymentMethodDataSource {
    override val paymentMethods: ArrayList<PaymentMethodDto>
        get() = (arrayListOf(PaymentMethodDto(id = 1, name = "Cash")))

}