package com.example.tendomini.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tendomini.R
import com.example.tendomini.data.Result
import com.example.tendomini.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    private val _loginForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _loginForm

    private val _loginResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _loginResult

    fun register(fullName: String, phoneNumber: String, email: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = userRepository.register(fullName, phoneNumber, email, password)

        if (result is Result.Success) {
            _loginResult.value =
                RegisterResult(success = result.data)
        } else {
            _loginResult.value = RegisterResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(fullName: String, phoneNumber: String, email: String, password: String) {
        if (!isFullNameNameValid(fullName)) {
            _loginForm.value = RegisterFormState(fullNameError = R.string.invalid_full_name)
        } else if (!isPhoneNumberValid(phoneNumber)) {
            _loginForm.value = RegisterFormState(phoneNumberError = R.string.invalid_phone_number)
        } else if (!isEmailNameValid(email)) {
            _loginForm.value = RegisterFormState(emailError = R.string.invalid_email)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = RegisterFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isFullNameNameValid(fullName: String): Boolean {
        return fullName.length > 4
    }

    private fun isPhoneNumberValid(phoneNumber: String): Boolean {

        val phoneNumberIntCode = phoneNumber.substring(4, phoneNumber.length)

        return if (!phoneNumberIntCode.isNullOrEmpty()) {

            val sub = phoneNumberIntCode.substring(0, 1)

            val phoneNumberFmt = if (sub == "0") {
                phoneNumberIntCode.substring(1, phoneNumberIntCode.length)
            } else {
                phoneNumberIntCode
            }

            phoneNumberFmt.length < 2 || phoneNumberFmt.length > 8
        } else {
            false
        }
    }


    private fun isEmailNameValid(email: String): Boolean {
        return if (email.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            email.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}