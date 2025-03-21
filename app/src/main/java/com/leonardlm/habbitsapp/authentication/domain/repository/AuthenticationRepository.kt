package com.leonardlm.habbitsapp.authentication.domain.repository

interface AuthenticationRepository {
    suspend fun login(email: String, password: String) : Result<Unit>
    suspend fun signUp(email: String, password: String) : Result<Unit>
    fun getUserId() : String?
    fun logOut() : Result<Unit>
}