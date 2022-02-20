package com.example.tendomini.data.datasource.local.entites

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings
import java.util.*

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(
    tableName = "orders"
)
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val code: String,

    val timestamp: Date,

    val description: String?,

    @Embedded(prefix = "delivery_location_")
    val deliveryLocation: DeliveryLocationEntity,

    val items: List<CartItemEntity>,
)


