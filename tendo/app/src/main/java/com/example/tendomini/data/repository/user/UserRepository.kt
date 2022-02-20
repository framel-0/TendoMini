package com.example.tendomini.data.repository.user

import com.example.tendomini.data.Result
import com.example.tendomini.data.datasource.local.entites.UserEntity
import com.example.tendomini.domain.models.User

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

interface UserRepository {

    val isLoggedIn: Boolean

    fun logout()

    fun login(username: String, password: String): Result<User>

    fun register(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ): Result<User>

}