package com.leonardlm.habbitsapp.authentication.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonardlm.habbitsapp.authentication.domain.model.PasswordResult
import com.leonardlm.habbitsapp.authentication.domain.model.SignupUseCases
import com.leonardlm.habbitsapp.authentication.presentation.model.SignupState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCases: SignupUseCases
): ViewModel() {
    var state by mutableStateOf(SignupState())
    private set

    fun onEvent(event: SignupEvent) {
        when(event) {
            is SignupEvent.EmailChange -> {
                state = state.copy(
                    email = event.email
                )
            }
            is SignupEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
            is SignupEvent.SignIn -> {
                state = state.copy(
                    signIn = true
                )
            }
            is SignupEvent.SignUp -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        state = state.copy(
            emailError = null,
            passwordError = null
        )
        if (!signupUseCases.validateEmailUseCase(state.email)) {
            state = state.copy(
                emailError = "Invalid email format"
            )
        }

        val passwordResult = signupUseCases.validatePasswordUseCase(state.password)
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
                signupUseCases.signupWithEmailUseCase(state.email, state.password).onSuccess {
                    state = state.copy(
                        success = "User created successfully"
                    )
                }.onFailure { error ->
                    state = state.copy(
                        serverError = error.message
                    )
                }
                state = state.copy(
                    isLoading = false
                )
            }
            state = state.copy(
                serverError = null,
                success = null
            )

        }

    }
}