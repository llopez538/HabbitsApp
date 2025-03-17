package com.leonardlm.habbitsapp.authentication.domain.usecase

import android.util.Patterns
import com.leonardlm.habbitsapp.authentication.domain.matcher.EmailMatcher

class ValidateEmailUseCase (private val emailMatcher: EmailMatcher){
    operator fun invoke(email: String): Boolean {
        return emailMatcher.isValid(email)
    }
}