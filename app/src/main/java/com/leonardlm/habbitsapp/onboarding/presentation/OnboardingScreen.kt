package com.leonardlm.habbitsapp.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.onboarding.presentation.components.OnBoardingPager
import com.leonardlm.habbitsapp.onboarding.presentation.models.OnBoardingPagerInformation
import com.leonardlm.habbitsapp.onboarding.presentation.viewmodel.OnBoardingViewModel
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    onFinish: () -> Unit
) {
    val hasSeenOnBoarding = viewModel.hasSeenOnBoarding.collectAsState(
        initial = true
    )
    val scope = rememberCoroutineScope()
    LaunchedEffect(viewModel.hasSeenOnBoarding) {
        if (hasSeenOnBoarding.value == true) {
            onFinish()
        }
    }
    val pages = listOf(
        OnBoardingPagerInformation(
            title = "WELCOME TO \nMonumental habits",
            subtitle = "We can *help you* to be a better \nversion of *yourself.*",
            image = R.drawable.onboarding1
        ),
        OnBoardingPagerInformation(
            title = "CREATE NEW HABIT EASILY",
            subtitle = "We can *help you* to be a better \nversion of *yourself.*",
            image = R.drawable.onboarding2
        ),
        OnBoardingPagerInformation(
            title = "KEEP TRACK OF YOUR PROGRESS",
            subtitle = "We can *help you* to be a better \nversion of *yourself.*",
            image = R.drawable.onboarding3
        ),
        OnBoardingPagerInformation(
            title = "JOIN A SUPPORTIVE COMMUNITY",
            subtitle = "We can *help you* to be a better \nversion of *yourself.*",
            image = R.drawable.onboarding4
        )
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        OnBoardingPager(
            pages = pages,
            onFinish = {
                scope.launch {
                    viewModel.completeOnBoarding()
                    onFinish()
                }
            }
        )
    }
}