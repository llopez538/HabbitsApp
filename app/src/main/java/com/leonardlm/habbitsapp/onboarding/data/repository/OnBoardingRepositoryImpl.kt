package com.leonardlm.habbitsapp.onboarding.data.repository

import com.leonardlm.habbitsapp.onboarding.data.soruce.local.OnBoardingStoreManager
import com.leonardlm.habbitsapp.onboarding.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val settingsDataStore: OnBoardingStoreManager,
): OnBoardingRepository {

    override fun hasSeenOnBoarding(): Flow<Boolean?> = settingsDataStore.hasSeenOnboarding()

    override suspend fun completeOnBoarding() = settingsDataStore.completeHasSeenOnboarding()

}
