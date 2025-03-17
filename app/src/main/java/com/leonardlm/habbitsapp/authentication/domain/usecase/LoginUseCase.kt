package com.leonardlm.habbitsapp.authentication.domain.usecase

import com.leonardlm.habbitsapp.authentication.domain.repository.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: AuthenticationRepository
) {
    suspend fun login(email: String, password: String) {
        loginRepository.login(email, password)
    }
}