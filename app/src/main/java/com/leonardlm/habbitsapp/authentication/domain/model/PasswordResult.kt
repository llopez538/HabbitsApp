package com.leonardlm.habbitsapp.authentication.domain.model

sealed class PasswordResult {
    data object Valid : PasswordResult()
    data class Invalid(val errorMessages: String) : PasswordResult()
}