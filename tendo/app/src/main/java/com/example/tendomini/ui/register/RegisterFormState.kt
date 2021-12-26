package com.example.tendomini.ui.register

/**
 * Data validation state of the login form.
 */
data class RegisterFormState(
    val fullNameError: Int? = null,
    val phoneNumberError: Int? = null,
    val emailError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)