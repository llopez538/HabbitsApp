package com.leonardlm.habbitsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leonardlm.habbitsapp.onboarding.domain.usecase.HasSeenOnBoardingUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val hasSeenOnBoardingUseCase: HasSeenOnBoardingUseCase
): ViewModel() {
    var hasSeenOnBoarding by mutableStateOf(hasSeenOnBoardingUseCase())
        private set

}