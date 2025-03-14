package com.leonardlm.habbitsapp.authentication.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.EmailChange -> {
                state = state.copy(
                    email = event.email
                )
            }
            is LoginEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
            is LoginEvent.Login -> {
                login()
            }
            is LoginEvent.SignUp -> {
                state = state.copy(
                    sigUp = true
                )
            }
        }
    }

    private fun login() {}
}