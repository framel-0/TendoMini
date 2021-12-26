package com.example.tendomini.ui.register

import com.example.tendomini.data.models.User

/**
 * Authentication result : success (user details) or error message.
 */
data class RegisterResult(
    val success: User? = null,
    val error: Int? = null
)