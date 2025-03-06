package com.leonardlm.habbitsapp.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonardlm.habbitsapp.onboarding.domain.usecase.CompleteOnBoardingUseCase
import com.leonardlm.habbitsapp.onboarding.domain.usecase.HasSeenOnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val hasSeenOnBoardingUseCase: HasSeenOnBoardingUseCase,
    private val completeOnBoardingUseCase: CompleteOnBoardingUseCase
): ViewModel() {
    private val _hasSeenOnBoarding = MutableStateFlow<Boolean?>(null)
    val hasSeenOnBoarding: StateFlow<Boolean?> = _hasSeenOnBoarding

    init {
        viewModelScope.launch {
            hasSeenOnBoardingUseCase().collectLatest { hasSeen ->
                _hasSeenOnBoarding.value = hasSeen
            }
        }
    }

    suspend fun completeOnBoarding() {
        completeOnBoardingUseCase()
    }
}
