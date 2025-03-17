package com.leonardlm.habbitsapp.authentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonardlm.habbitsapp.authentication.domain.model.LoginUseCases
import com.leonardlm.habbitsapp.authentication.domain.model.PasswordResult
import com.leonardlm.habbitsapp.authentication.domain.usecase.LoginWithEmailUseCase
import com.leonardlm.habbitsapp.authentication.login.LoginEvent
import com.leonardlm.habbitsapp.authentication.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
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

    private fun login() {
        state = state.copy(
            emailError = null,
            passwordError = null
        )
        if (!loginUseCases.validateEmailUseCase(state.email)) {
            state = state.copy(
                emailError = "Invalid email format"
            )
        }

        val passwordResult = loginUseCases.validatePasswordUseCase(state.password)
        if (passwordResult is PasswordResult.Invalid) {
            state = state.copy(
                passwordError = passwordResult.errorMessages
            )
        }

        if (state.emailError == null && state.passwordError == null) {
            state = state.copy(
                isLoading = true
            )

            viewModelScope.launch {
                loginUseCases.loginWithEmailUseCase(state.email, state.password).onSuccess {
                    state = state.copy(
                        isLoggedIn = true
                    )
                }.onFailure {
                    state = state.copy(
                        emailError = it.message,
                    )
                }

                state = state.copy(
                    isLoading = false
                )
            }
        }
    }
}