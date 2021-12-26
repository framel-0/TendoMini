package com.example.tendomini.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "delivery_locations"
)
@Parcelize
data class DeliveryLocation(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: Double,
) : Parcelable {

    override fun toString(): String {
        return String.format("%s  GHC %,.2f ", name, price)
    }
}
