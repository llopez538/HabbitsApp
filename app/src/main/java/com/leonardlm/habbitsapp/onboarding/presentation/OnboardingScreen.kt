package com.leonardlm.habbitsapp.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leonardlm.habbitsapp.onboarding.presentation.components.OnBoardingPager

@Composable
fun OnboardingScreen() {
    val pages = listOf(
        "Title 1",
        "Title 2",
        "Title 3"
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        OnBoardingPager(pages = pages, onFinish = {})
    }
}