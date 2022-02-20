package com.example.tendomini.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class DeliveryLocation(
    val id: Int,
    val name: String,
    val price: Double,
) : Parcelable {
    override fun toString(): String {
        return String.format("%s  GHC %,.2f ", name, price)
    }
}
