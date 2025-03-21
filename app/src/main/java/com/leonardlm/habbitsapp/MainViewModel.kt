package com.leonardlm.habbitsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leonardlm.habbitsapp.authentication.domain.usecase.GetUserIdUseCase
import com.leonardlm.habbitsapp.onboarding.domain.usecase.HasSeenOnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val hasSeenOnBoardingUseCase: HasSeenOnBoardingUseCase,
    private val getUserIdUseCase: GetUserIdUseCase
): ViewModel() {
    var hasSeenOnBoarding by mutableStateOf(hasSeenOnBoardingUseCase())
    private set

    var isLoggedIn by mutableStateOf(getUserIdUseCase() != null)
        private set
}