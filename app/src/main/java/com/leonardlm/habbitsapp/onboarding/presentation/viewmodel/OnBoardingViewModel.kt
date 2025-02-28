package com.leonardlm.habbitsapp.onboarding.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leonardlm.habbitsapp.onboarding.domain.usecase.CompleteOnBoardingUseCase
import com.leonardlm.habbitsapp.onboarding.domain.usecase.HasSeenOnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val hasSeenOnBoardingUseCase: HasSeenOnBoardingUseCase,
    private val completeOnBoardingUseCase: CompleteOnBoardingUseCase
): ViewModel() {
    var hasSeenOnBoarding by mutableStateOf(hasSeenOnBoardingUseCase())
        private set

    suspend fun completeOnBoarding() {
        completeOnBoardingUseCase()
        hasSeenOnBoarding = flow { 
            emit(true)
        }
    }


}
