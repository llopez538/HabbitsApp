package com.leonardlm.habbitsapp.onboarding.presentation.models

import androidx.annotation.DrawableRes

data class OnBoardingPagerInformation(
    val title: String,
    val subtitle: String,
    @DrawableRes val image: Int
)
