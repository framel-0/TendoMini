package com.example.tendomini.data.datasource.remote.deliveryLocation

import com.example.tendomini.data.datasource.remote.dtos.DeliveryLocationDto

interface DeliveryLocationDataSource {
    val deliveryLocations: ArrayList<DeliveryLocationDto>
}