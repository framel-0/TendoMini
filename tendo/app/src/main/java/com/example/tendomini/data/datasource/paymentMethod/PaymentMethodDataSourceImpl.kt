package com.example.tendomini.data.datasource.paymentMethod

import com.example.tendomini.data.models.PaymentMethod
import com.example.tendomini.data.models.Result

class PaymentMethodDataSourceImpl :
    PaymentMethodDataSource {
    override val paymentMethods: Result<ArrayList<PaymentMethod>>
        get() = Result.Success(arrayListOf<PaymentMethod>(PaymentMethod(id = 1, name = "Cash")))

}