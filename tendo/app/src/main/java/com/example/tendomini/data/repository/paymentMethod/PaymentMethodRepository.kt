package com.example.tendomini.data.repository.paymentMethod

import com.example.tendomini.data.Result
import com.example.tendomini.domain.models.PaymentMethod

interface PaymentMethodRepository {
    fun getPaymentMethods(): Result<List<PaymentMethod>>
}