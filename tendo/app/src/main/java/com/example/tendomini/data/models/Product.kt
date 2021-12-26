package com.example.tendomini.data.models


import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Entity(
    tableName = "products"
)
@Parcelize
data class Product(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("price")
    val price: Double,

//    @Ignore
    @DrawableRes
    val images: List<Int>,

    @SerializedName("categoryId")
    @ColumnInfo(name = "category_id")
    val categoryId: Int

) : Parcelable {
    val displayPrice: String
        get() = String.format("GHC %,.2f ", price)


}

@ProvidedTypeConverter
class ImageConverters {
    @TypeConverter
    fun toImages(value: String?) =
        Gson().fromJson(value, Array<Int>::class.java).toList()

    @TypeConverter
    fun fromImages(value: List<Int>?) =
        Gson().toJson(value)
}

