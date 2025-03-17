package com.leonardlm.habbitsapp.authentication.data.matcher

import android.util.Patterns
import com.leonardlm.habbitsapp.authentication.domain.matcher.EmailMatcher

class EmailMatcherImpl : EmailMatcher {
    override fun isValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}