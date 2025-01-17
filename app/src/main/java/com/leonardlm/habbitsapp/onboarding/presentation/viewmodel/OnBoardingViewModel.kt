package com.leonardlm.habbitsapp.onboarding.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.leonardlm.habbitsapp.onboarding.domain.usecase.CompleteOnBoardingUseCase
import com.leonardlm.habbitsapp.onboarding.domain.usecase.HasSeenOnBoardingUseCase
import kotlinx.coroutines.flow.flow

class OnBoardingViewModel(
    private val hasSeenOnBoardingUseCase: HasSeenOnBoardingUseCase,
    private val completeOnBoardingUseCase: CompleteOnBoardingUseCase
) {
    var hasSeenOnBoarding by mutableStateOf(hasSeenOnBoardingUseCase())
        private set

    suspend fun completeOnBoarding() {
        completeOnBoardingUseCase()
        hasSeenOnBoarding = flow { 
            emit(true)
        }
    }


}