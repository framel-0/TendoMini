package com.example.tendomini.data.repository.user

import com.example.tendomini.data.Result
import com.example.tendomini.data.datasource.remote.mappers.UserDtoMapper
import com.example.tendomini.data.datasource.remote.user.UserDataSource
import com.example.tendomini.domain.models.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource,
    private val dtoMapper: UserDtoMapper
) :
    UserRepository {

    // in-memory cache of the loggedInUser object
    var user: User? = null
        private set

    override val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    override fun logout() {
        user = null
        dataSource.logout()
    }

    override fun login(username: String, password: String): Result<User> {

        try {
            // handle login
            val result = dataSource.login(username, password)

            val user = dtoMapper.mapToDomainModel(result)

            setLoggedInUser(user)

            return Result.Success(user)

        } catch (e: Exception) {
            return Result.Error(e)
        }

    }

    override fun register(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ): Result<User> {
        try {
            // handle login
            val result = dataSource.register(fullName, phoneNumber, email, password)

            val user = dtoMapper.mapToDomainModel(result)

            setLoggedInUser(user)

            return Result.Success(user)

        } catch (e: Exception) {
            return Result.Error(e)
        }

    }

    private fun setLoggedInUser(loggedInUser: User) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}