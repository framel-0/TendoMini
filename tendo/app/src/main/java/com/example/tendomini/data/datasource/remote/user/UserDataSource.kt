package com.example.tendomini.data.datasource.remote.user

import com.example.tendomini.data.datasource.remote.dtos.UserDto


interface UserDataSource {

    fun login(phoneNumber: String, password: String): UserDto

    fun register(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ): UserDto

    fun logout()
}