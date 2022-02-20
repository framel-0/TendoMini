package com.example.tendomini.data.datasource.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "delivery_locations"
)
data class DeliveryLocationEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val name: String,

    val price: Double,
)
