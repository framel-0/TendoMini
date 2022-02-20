package com.example.tendomini.data.datasource.local.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity(tableName = "users")
data class UserEntity(

    @ColumnInfo(name = "user_id")
    val id: Int,

    @ColumnInfo(name = "full_name")
    val fullName: String,

    val email: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String

) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var userId: Int = CURRENT_USER_ID

}