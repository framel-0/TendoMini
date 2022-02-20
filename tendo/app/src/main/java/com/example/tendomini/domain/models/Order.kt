package com.example.tendomini.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class Order(
    val id: Int,
    val code: String,
    val timestamp: Date,
    val description: String?,
    val deliveryLocation: DeliveryLocation,
    val items: List<CartItem>,
) : Parcelable {

    val dateFmt: String
        get() {
            val dateFormat = SimpleDateFormat(
                "dd/MM/yyyy HH:mm", Locale.getDefault()
            )

            val date = dateFormat.format(timestamp)

            return date.toString()
        }

    val itemsCost: Double
        get() {
            var price = 0.0
            items.forEach {
                price += (it.product.price * it.quantity)
            }
            return price
        }

    val itemsCostFmt: String
        get() = String.format("GHC %,.2f ", itemsCost)


    val itemsCount: Int
        get() {
            var quantity = 0
            items.forEach {
                quantity += it.quantity
            }
            return quantity
        }

    val itemsCountFmt: String
        get() {
            var quantity = 0
            items.forEach {
                quantity += it.quantity
            }
            return quantity.toString()
        }


    val deliveryCost: Double
        get() = deliveryLocation.price

    val deliveryCostFmt: String
        get() = String.format("GHC %,.2f ", deliveryCost)


    val totalCost: Double
        get() = itemsCost + deliveryCost

    val totalCostFmt: String
        get() = String.format("GHC %,.2f ", totalCost)


}

