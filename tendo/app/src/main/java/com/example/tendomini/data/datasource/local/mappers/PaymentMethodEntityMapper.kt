package com.example.tendomini.data.datasource.local.mappers

import com.example.tendomini.data.datasource.local.entites.PaymentMethodEntity
import com.example.tendomini.domain.models.PaymentMethod
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentMethodEntityMapper @Inject constructor() : DomainModelMapper<PaymentMethodEntity, PaymentMethod> {
    override fun mapToDomainModel(model: PaymentMethodEntity): PaymentMethod {
        return PaymentMethod(
            id = model.id,
            name = model.name,
        )
    }

    override fun mapFromDomainModel(domainModel: PaymentMethod): PaymentMethodEntity {
        return PaymentMethodEntity(
            id = domainModel.id,
            name = domainModel.name,
        )
    }
}