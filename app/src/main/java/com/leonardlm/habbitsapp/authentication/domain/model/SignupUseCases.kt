package com.leonardlm.habbitsapp.authentication.domain.model

import com.leonardlm.habbitsapp.authentication.domain.usecase.SignupWithEmailUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.ValidateEmailUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.ValidatePasswordUseCase

data class SignupUseCases(
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val signupWithEmailUseCase: SignupWithEmailUseCase
)
