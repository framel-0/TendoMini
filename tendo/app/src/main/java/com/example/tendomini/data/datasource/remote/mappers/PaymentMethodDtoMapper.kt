package com.example.tendomini.data.datasource.remote.mappers

import com.example.tendomini.data.datasource.remote.dtos.PaymentMethodDto
import com.example.tendomini.domain.models.PaymentMethod
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentMethodDtoMapper @Inject constructor() : DomainModelMapper<PaymentMethodDto, PaymentMethod> {
    override fun mapToDomainModel(model: PaymentMethodDto): PaymentMethod {
        return PaymentMethod(
            id = model.id,
            name = model.name,
        )
    }

    override fun mapFromDomainModel(domainModel: PaymentMethod): PaymentMethodDto {
        return PaymentMethodDto(
            id = domainModel.id,
            name = domainModel.name,
        )
    }

    fun toDomainList(initial: List<PaymentMethodDto>): List<PaymentMethod>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<PaymentMethod>): List<PaymentMethodDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}