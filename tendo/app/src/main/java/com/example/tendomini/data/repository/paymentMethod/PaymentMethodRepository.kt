package com.example.tendomini.data.repository.paymentMethod

import com.example.tendomini.data.models.PaymentMethod
import com.example.tendomini.data.models.Result

interface PaymentMethodRepository {
    fun getPaymentMethods(): Result<ArrayList<PaymentMethod>>
}