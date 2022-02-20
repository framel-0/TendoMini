package com.example.tendomini.data.datasource.remote.deliveryLocation

import com.example.tendomini.data.datasource.remote.dtos.DeliveryLocationDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeliveryLocationDataSourceImpl @Inject constructor() : DeliveryLocationDataSource {

    val list = arrayListOf(
        DeliveryLocationDto(
            id = 1,
            name = "Lapaz",
            price = 30.0,
        ),
        DeliveryLocationDto(
            id = 1,
            name = "Achimota",
            price = 25.0,
        ),
        DeliveryLocationDto(
            id = 1,
            name = "Dzorwulu",
            price = 25.0,
        ),
        DeliveryLocationDto(
            id = 1,
            name = "Shiashei",
            price = 20.0,
        ),
        DeliveryLocationDto(
            id = 1,
            name = "East Legon",
            price = 15.0,
        )
    )

    override val deliveryLocations: ArrayList<DeliveryLocationDto>
        get() = (list)
}