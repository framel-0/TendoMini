package com.example.tendomini.data.repository.deliveryLocation

import com.example.tendomini.data.datasource.deliveryLocation.DeliveryLocationDataSource
import com.example.tendomini.data.models.DeliveryLocation
import com.example.tendomini.data.models.Result

class DeliveryLocationRepositoryImpl(private val dataSource: DeliveryLocationDataSource) :
    DeliveryLocationRepository {
    override fun getDeliveryLocations(): Result<ArrayList<DeliveryLocation>> {
        return dataSource.deliveryLocations
    }
}