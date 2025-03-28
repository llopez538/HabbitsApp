package com.leonardlm.habbitsapp.authentication.presentation.model

data class SignupState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val isSignedIn: Boolean = false,
    val logIn: Boolean = false,
    val serverError: String? = null,
    val success: String? = null
)
