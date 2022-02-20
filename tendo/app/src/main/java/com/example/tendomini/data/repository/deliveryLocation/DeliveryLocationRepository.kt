package com.example.tendomini.data.repository.deliveryLocation

import com.example.tendomini.data.Result
import com.example.tendomini.domain.models.DeliveryLocation

interface DeliveryLocationRepository {
    fun getDeliveryLocations(): Result<List<DeliveryLocation>>
}