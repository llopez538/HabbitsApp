package com.leonardlm.habbitsapp.authentication.presentation.model

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val sigUp: Boolean = false,
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val serverError: String? = null
)