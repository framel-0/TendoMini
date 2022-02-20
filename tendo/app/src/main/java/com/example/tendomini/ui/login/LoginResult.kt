package com.example.tendomini.ui.login

import com.example.tendomini.domain.models.User

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: User? = null,
    val error: Int? = null
)