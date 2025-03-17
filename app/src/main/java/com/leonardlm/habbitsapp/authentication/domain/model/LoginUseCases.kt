package com.leonardlm.habbitsapp.authentication.domain.model

import com.leonardlm.habbitsapp.authentication.domain.usecase.LoginWithEmailUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.ValidateEmailUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.ValidatePasswordUseCase

data class LoginUseCases(
    val loginWithEmailUseCase: LoginWithEmailUseCase,
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase

)