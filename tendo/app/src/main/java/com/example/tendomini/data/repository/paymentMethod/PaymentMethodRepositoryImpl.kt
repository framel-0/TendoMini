package com.example.tendomini.data.repository.paymentMethod

import com.example.tendomini.data.datasource.paymentMethod.PaymentMethodDataSource
import com.example.tendomini.data.models.PaymentMethod
import com.example.tendomini.data.models.Result

class PaymentMethodRepositoryImpl(private val dataSource: PaymentMethodDataSource) : PaymentMethodRepository {
    override fun getPaymentMethods(): Result<ArrayList<PaymentMethod>> {
       return dataSource.paymentMethods
    }
}