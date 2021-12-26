package com.example.tendomini.data.repository.user

import com.example.tendomini.data.datasource.user.UserDataSource
import com.example.tendomini.data.models.Result
import com.example.tendomini.data.models.User

class UserRepositoryImpl(private val  dataSource: UserDataSource) : UserRepository{

    // in-memory cache of the loggedInUser object
    var user: User? = null
        private set

    override val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    override fun logout() {
        user = null
        dataSource.logout()
    }

    override fun login(username: String, password: String): Result<User> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    override fun register(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ): Result<User> {
        // handle register
        val result = dataSource.register(fullName, phoneNumber, email, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: User) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}