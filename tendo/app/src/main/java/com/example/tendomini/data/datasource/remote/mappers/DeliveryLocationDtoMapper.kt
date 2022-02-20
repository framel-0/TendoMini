package com.example.tendomini.data.datasource.remote.mappers

import com.example.tendomini.data.datasource.remote.dtos.DeliveryLocationDto
import com.example.tendomini.domain.models.DeliveryLocation
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeliveryLocationDtoMapper @Inject constructor() : DomainModelMapper<DeliveryLocationDto, DeliveryLocation> {
    override fun mapToDomainModel(model: DeliveryLocationDto): DeliveryLocation {
        return DeliveryLocation(
            id = model.id,
            name = model.name,
            price = model.price
        )
    }

    override fun mapFromDomainModel(domainModel: DeliveryLocation): DeliveryLocationDto {
        return DeliveryLocationDto(
            id = domainModel.id,
            name = domainModel.name,
            price = domainModel.price
        )
    }

    fun toDomainList(initial: List<DeliveryLocationDto>): List<DeliveryLocation> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<DeliveryLocation>): List<DeliveryLocationDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}