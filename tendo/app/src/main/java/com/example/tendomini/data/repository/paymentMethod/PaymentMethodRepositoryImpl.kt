package com.example.tendomini.data.repository.paymentMethod

import com.example.tendomini.data.Result
import com.example.tendomini.data.datasource.remote.mappers.PaymentMethodDtoMapper
import com.example.tendomini.data.datasource.remote.paymentMethod.PaymentMethodDataSource
import com.example.tendomini.domain.models.PaymentMethod
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentMethodRepositoryImpl @Inject constructor(
    private val dataSource: PaymentMethodDataSource,
    private val dtoMapper: PaymentMethodDtoMapper
) :
    PaymentMethodRepository {
    override fun getPaymentMethods(): Result<List<PaymentMethod>> {
        try {

            val paymentMethodsDto = dataSource.paymentMethods
            return Result.Success(dtoMapper.toDomainList(paymentMethodsDto))

        } catch (e: Exception) {
            return Result.Error(e)
        }

    }
}