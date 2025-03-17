package com.leonardlm.habbitsapp.authentication.domain.matcher

interface EmailMatcher {
    fun isValid(email: String): Boolean
}