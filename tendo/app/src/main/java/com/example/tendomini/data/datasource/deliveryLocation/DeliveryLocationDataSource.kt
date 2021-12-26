package com.example.tendomini.data.datasource.deliveryLocation

import com.example.tendomini.data.models.DeliveryLocation
import com.example.tendomini.data.models.Result

interface DeliveryLocationDataSource {
    val deliveryLocations: Result<ArrayList<DeliveryLocation>>
}