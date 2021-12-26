package com.example.tendomini.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_USER_ID = 0

@Entity(tableName = "users")
data class User(

    @SerializedName("id")
    @ColumnInfo(name = "user_id")
    val id: Int,

    @SerializedName("fullName")
    @ColumnInfo(name = "full_name")
    val fullName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("phoneNumber")
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String

) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var userId: Int = CURRENT_USER_ID

}