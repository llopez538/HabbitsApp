package com.leonardlm.habbitsapp.authentication.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        viewModelScope.launch {
            signupUseCases.signupWithEmailUseCase(state.email, state.password)
        }
    }
}