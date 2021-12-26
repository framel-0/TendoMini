package com.example.tendomini.data.datasource.deliveryLocation

import com.example.tendomini.data.models.DeliveryLocation
import com.example.tendomini.data.models.Result

class DeliveryLocationDataSourceImpl : DeliveryLocationDataSource {

    val list = arrayListOf(
        DeliveryLocation(
            id = 1,
            name = "Lapaz",
            price = 30.0,
        ),
        DeliveryLocation(
            id = 1,
            name = "Achimota",
            price = 25.0,
        ),
        DeliveryLocation(
            id = 1,
            name = "Dzorwulu",
            price = 25.0,
        ),
        DeliveryLocation(
            id = 1,
            name = "Shiashei",
            price = 20.0,
        ),
        DeliveryLocation(
            id = 1,
            name = "East Legon",
            price = 15.0,
        )
    )

    override val deliveryLocations: Result<ArrayList<DeliveryLocation>>
        get() = Result.Success(list)
}