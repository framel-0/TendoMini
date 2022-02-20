package com.example.tendomini.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartItem(
    val id: Int = 0,

    var product: Product,
    var quantity: Int = 1
) : Parcelable {
    val quantityFmt: String
        get() = quantity.toString()

    override fun toString(): String {
        return String.format(
            "%s %,.2f x %d  %,.2f",
            product.name,
            product.price,
            quantity,
            product.price * quantity
        )
    }
}