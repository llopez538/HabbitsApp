package com.leonardlm.habbitsapp.navigation.models

import androidx.annotation.DrawableRes
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.navigation.DateGraph
import com.leonardlm.habbitsapp.navigation.Profile
import com.leonardlm.habbitsapp.navigation.Settings

data class TopLevelRoute<T: Any>(
    val label: String,
    val route: T,
    @DrawableRes val icon: Int,
)

object NavigationBarItems {
    val items = listOf(
        TopLevelRoute(
            label = "Profile",
            route = Profile,
            icon = R.drawable.ic_launcher_foreground,
        ),
        TopLevelRoute(
            label = "Date",
            route = DateGraph,
            icon = R.drawable.ic_launcher_foreground,
        ),
        TopLevelRoute(
            label = "Settings",
            route = Settings,
            icon = R.drawable.ic_launcher_foreground,
        ),
    )
}