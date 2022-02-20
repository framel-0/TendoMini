package com.example.tendomini.domain.models


import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes
    val images: List<Int>,
    val categoryId: Int

) : Parcelable {
    val displayPrice: String
        get() = String.format("GHC %,.2f ", price)

}
