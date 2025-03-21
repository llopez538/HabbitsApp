package com.leonardlm.habbitsapp.authentication.data.repository

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.leonardlm.habbitsapp.authentication.domain.repository.AuthenticationRepository
import kotlinx.coroutines.tasks.await

class AuthenticationRepositoryImpl: AuthenticationRepository {
    override suspend fun login(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUp(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.createUserWithEmailAndPassword(
                email,
                password
            ).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getUserId(): String? {
        return Firebase.auth.currentUser?.uid
    }

    override fun logOut(): Result<Unit> {
        return try {
            Firebase.auth.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}