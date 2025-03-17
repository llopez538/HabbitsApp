package com.leonardlm.habbitsapp.authentication.domain.usecase

import com.leonardlm.habbitsapp.authentication.domain.repository.AuthenticationRepository
import javax.inject.Inject

class LoginWithEmailUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.login(email, password)
    }
}