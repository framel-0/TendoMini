package com.example.tendomini.data.datasource.user

import com.example.tendomini.data.models.Result
import com.example.tendomini.data.models.User


interface UserDataSource {

    fun login(phoneNumber: String, password: String): Result<User>

    fun register(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ): Result<User>

    fun logout()
}