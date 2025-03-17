package com.leonardlm.habbitsapp.authentication.domain.usecase

import com.leonardlm.habbitsapp.authentication.domain.model.PasswordResult

class ValidatePasswordUseCase {
    operator fun invoke(password: String): PasswordResult {
        if (password.length < 8) {
            return PasswordResult.Invalid("Password must be at least 8 characters long")
        }
        if (!password.any { it.isUpperCase() }) {
            return PasswordResult.Invalid("Password must contain at least one uppercase letter")
        }
        if (!password.any { it.isLowerCase() }) {
            return PasswordResult.Invalid("Password must contain at least one lowercase letter")
        }
        if (!password.any { it.isDigit() }) {
            return PasswordResult.Invalid("Password must contain at least one digit")
        }
        return PasswordResult.Valid
    }
}