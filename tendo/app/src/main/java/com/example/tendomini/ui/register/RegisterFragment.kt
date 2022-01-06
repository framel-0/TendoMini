package com.example.tendomini.ui.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.tendomini.R
import com.example.tendomini.databinding.FragmentRegisterBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class RegisterFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    private lateinit var registerViewModel: RegisterViewModel
    private val viewModelFactory: RegisterViewModelFactory by instance()

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerViewModel = ViewModelProvider(this, viewModelFactory)
            .get(RegisterViewModel::class.java)

        val fullNameEditText = binding.editTextRegisterFullName
        val phoneNumberEditText = binding.editTextRegisterPhoneNumber
        val emailEditText = binding.editTextRegisterEmail
        val passwordEditText = binding.editTextRegisterPassword
        val registerButton = binding.buttonRegister
        val loadingProgressBar = binding.loading
        val signInTextView = binding.textRegisterSignIn

        phoneNumberEditText.setText("+233")

        registerViewModel.registerFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                registerButton.isEnabled = loginFormState.isDataValid
                loginFormState.fullNameError?.let {
                    fullNameEditText.error = getString(it)
                }
                loginFormState.phoneNumberError?.let {
                    phoneNumberEditText.error = getString(it)
                }
                loginFormState.emailError?.let {
                    emailEditText.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    passwordEditText.error = getString(it)
                }
            })

        registerViewModel.registerResult.observe(viewLifecycleOwner,
            Observer { loginResult ->
                loginResult ?: return@Observer
                loadingProgressBar.visibility = View.GONE
                loginResult.error?.let {
                    showLoginFailed(it)
                }
                loginResult.success?.let {
                    navigateToLogin()
                }
            })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                registerViewModel.loginDataChanged(
                    fullNameEditText.text.toString(),
                    phoneNumberEditText.text.toString(),
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
        fullNameEditText.addTextChangedListener(afterTextChangedListener)
        phoneNumberEditText.addTextChangedListener(afterTextChangedListener)
        emailEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                registerViewModel.register(
                    fullNameEditText.text.toString(),
                    phoneNumberEditText.text.toString(),
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
            false
        }

        registerButton.setOnClickListener {

            val phoneNumber  = phoneNumberEditText.text.toString()

            val phoneNumberIntCode = phoneNumber.substring(4, phoneNumber.length)

                val sub = phoneNumberIntCode.substring(0, 1)

                val phoneNumberFmt = if (sub == "0") {
                    phoneNumberIntCode.substring(1, phoneNumberIntCode.length)
                } else {
                    phoneNumberIntCode
                }

            val passwordEdt = "+233$phoneNumberFmt"

            loadingProgressBar.visibility = View.VISIBLE
            registerViewModel.register(
                fullNameEditText.text.toString(),
                passwordEdt,
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

        signInTextView.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.loginFragment)
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}