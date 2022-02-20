package com.example.tendomini.data.datasource.remote.user

import com.example.tendomini.data.datasource.remote.dtos.UserDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataSourceImpl @Inject constructor() : UserDataSource {

    override fun login(phoneNumber: String, password: String): UserDto {
        val sampleUser = UserDto(0, "Jane Doe", "jane.doe@example.com", "0240687954")
        return sampleUser
    }

    override fun register(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ): UserDto {

        val sampleUser = UserDto(0, "Jane Doe", "jane.doe@example.com", "0240687954")
        return (sampleUser)
    }

    override fun logout() {
        // TODO: revoke authentication
    }

}