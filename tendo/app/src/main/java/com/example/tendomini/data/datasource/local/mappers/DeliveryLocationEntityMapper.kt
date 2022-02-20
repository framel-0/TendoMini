package com.example.tendomini.data.datasource.local.mappers

import com.example.tendomini.data.datasource.local.entites.DeliveryLocationEntity
import com.example.tendomini.domain.models.DeliveryLocation
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeliveryLocationEntityMapper @Inject constructor() :
    DomainModelMapper<DeliveryLocationEntity, DeliveryLocation> {
    override fun mapToDomainModel(model: DeliveryLocationEntity): DeliveryLocation {
        return DeliveryLocation(
            id = model.id,
            name = model.name,
            price = model.price
        )
    }

    override fun mapFromDomainModel(domainModel: DeliveryLocation): DeliveryLocationEntity {
        return DeliveryLocationEntity(
            id = domainModel.id,
            name = domainModel.name,
            price = domainModel.price
        )
    }
}