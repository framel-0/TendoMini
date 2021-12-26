package com.example.tendomini.data.datasource.paymentMethod

import com.example.tendomini.data.models.PaymentMethod
import com.example.tendomini.data.models.Result

interface PaymentMethodDataSource {

    val paymentMethods: Result<ArrayList<PaymentMethod>>


}