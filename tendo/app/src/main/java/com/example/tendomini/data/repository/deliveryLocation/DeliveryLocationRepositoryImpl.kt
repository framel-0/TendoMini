package com.example.tendomini.data.repository.deliveryLocation

import com.example.tendomini.data.Result
import com.example.tendomini.data.datasource.remote.deliveryLocation.DeliveryLocationDataSource
import com.example.tendomini.data.datasource.remote.mappers.DeliveryLocationDtoMapper
import com.example.tendomini.domain.models.DeliveryLocation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeliveryLocationRepositoryImpl @Inject constructor(
    private val dataSource: DeliveryLocationDataSource,
    private val dtoMapper: DeliveryLocationDtoMapper
) :
    DeliveryLocationRepository {

    override fun getDeliveryLocations(): Result<List<DeliveryLocation>> {
        return try {

            val locationsDto = dataSource.deliveryLocations
            Result.Success(dtoMapper.toDomainList(locationsDto))

        } catch (e: Exception) {
            Result.Error(e)
        }

    }
}