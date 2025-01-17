package com.leonardlm.habbitsapp.onboarding.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {
    fun hasSeenOnBoarding(): Flow<Boolean?>
    suspend fun completeOnBoarding()
}