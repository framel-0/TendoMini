package com.example.tendomini.data.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Entity(
    tableName = "orders"
)
@Parcelize
data class CartItem(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @Embedded(prefix = "product_")
    var product: Product,
    var quantity: Int = 1
) : Parcelable {
    val quantityFmt: String
        get() = quantity.toString()

    override fun toString(): String {
        return String.format("%s %,.2f x %d  %,.2f", product.name, product.price, quantity, product.price * quantity)
    }
}