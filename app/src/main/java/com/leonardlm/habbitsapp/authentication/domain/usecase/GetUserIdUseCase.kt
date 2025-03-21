package com.leonardlm.habbitsapp.authentication.domain.usecase

import com.leonardlm.habbitsapp.authentication.domain.repository.AuthenticationRepository
import javax.inject.Inject

class GetUserIdUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(): String? {
        return repository.getUserId()
    }
}