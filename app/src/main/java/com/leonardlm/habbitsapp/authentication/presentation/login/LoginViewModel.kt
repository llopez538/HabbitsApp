package com.leonardlm.habbitsapp.authentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leonardlm.habbitsapp.authentication.domain.usecase.LoginUseCase
import com.leonardlm.habbitsapp.authentication.login.LoginEvent
import com.leonardlm.habbitsapp.authentication.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
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

            else -> {}
        }
    }

    private fun login() {}
}