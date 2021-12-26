package com.example.tendomini.data.repository.deliveryLocation

import com.example.tendomini.data.models.DeliveryLocation
import com.example.tendomini.data.models.Result

interface DeliveryLocationRepository {
    fun getDeliveryLocations(): Result<ArrayList<DeliveryLocation>>
}