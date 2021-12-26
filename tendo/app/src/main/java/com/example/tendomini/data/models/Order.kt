package com.example.tendomini.data.models

import android.os.Parcelable
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Entity(
    tableName = "order_items"
)
@Parcelize
data class Order(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("code")
    val code: String,

    @SerializedName("date")
    val timestamp: Date,

    @SerializedName("description")
    val description: String?,

    @SerializedName("deliveryLocation")
    @Embedded(prefix = "delivery_location_")
    val deliveryLocation: DeliveryLocation,

    @SerializedName("items")
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

@ProvidedTypeConverter
class ItemConverters {
    @TypeConverter
    fun toItems(value: String?) =
        Gson().fromJson(value, Array<CartItem>::class.java).toList()

    @TypeConverter
    fun fromItems(value: List<CartItem>?) =
        Gson().toJson(value)
}
