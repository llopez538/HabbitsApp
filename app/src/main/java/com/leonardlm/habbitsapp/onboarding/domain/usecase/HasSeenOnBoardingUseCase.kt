package com.leonardlm.habbitsapp.onboarding.domain.usecase

import com.leonardlm.habbitsapp.onboarding.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow

class HasSeenOnBoardingUseCase(
    private val repository: OnBoardingRepository
) {
    operator fun invoke(): Flow<Boolean?> {
        return repository.hasSeenOnBoarding()
    }

}