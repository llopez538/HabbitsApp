package com.leonardlm.habbitsapp.onboarding.domain.usecase

import com.leonardlm.habbitsapp.onboarding.domain.repository.OnBoardingRepository

class CompleteOnBoardingUseCase(
    private val repository: OnBoardingRepository
) {
    suspend operator fun invoke() {
        repository.completeOnBoarding()
    }

}