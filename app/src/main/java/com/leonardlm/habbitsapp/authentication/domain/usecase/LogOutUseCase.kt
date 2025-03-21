package com.leonardlm.habbitsapp.authentication.domain.usecase

import com.leonardlm.habbitsapp.authentication.domain.repository.AuthenticationRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(): Result<Unit> {
        return repository.logOut()
    }
}