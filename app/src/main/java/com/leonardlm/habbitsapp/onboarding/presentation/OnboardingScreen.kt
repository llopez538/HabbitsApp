package com.leonardlm.habbitsapp.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.onboarding.presentation.components.OnBoardingPager
import com.leonardlm.habbitsapp.onboarding.presentation.components.Screen
import com.leonardlm.habbitsapp.onboarding.presentation.models.OnBoardingPagerInformation

@Composable
fun OnboardingScreen() {
    val pages = listOf(
        OnBoardingPagerInformation(
            title = "WELCOME TO Monumental habits",
            subtitle = "We can *help you* to be a better version of *yourself.*",
            image = R.drawable.onboarding1
        ),
        OnBoardingPagerInformation(
            title = "CREATE NEW HABIT EASILY",
            subtitle = "Description 2",
            image = R.drawable.onboarding2
        ),
        OnBoardingPagerInformation(
            title = "KEEP TRACK OF YOUR PROGRESS",
            subtitle = "Description 3",
            image = R.drawable.onboarding3
        ),
        OnBoardingPagerInformation(
            title = "JOIN A SUPPORTIVE COMMUNITY",
            subtitle = "Description 3",
            image = R.drawable.onboarding4
        )
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        OnBoardingPager(pages = pages, onFinish = {})
    }
}