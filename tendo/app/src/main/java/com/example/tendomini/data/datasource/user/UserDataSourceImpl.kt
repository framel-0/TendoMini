package com.example.tendomini.data.datasource.user

import com.example.tendomini.data.models.Result
import com.example.tendomini.data.models.User
import java.io.IOException

class UserDataSourceImpl : UserDataSource {

    override fun login(phoneNumber: String, password: String): Result<User> {
        try {
            val sampleUser = User(0, "Jane Doe", "jane.doe@example.com", "0240687954")
            return Result.Success(sampleUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    override fun register(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ): Result<User> {
        try {
            val sampleUser = User(0, "Jane Doe", "jane.doe@example.com", "0240687954")
            return Result.Success(sampleUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    override fun logout() {
        // TODO: revoke authentication
    }

}