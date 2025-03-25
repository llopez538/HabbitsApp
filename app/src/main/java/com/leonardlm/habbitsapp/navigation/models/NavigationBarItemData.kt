package com.leonardlm.habbitsapp.navigation.models

import androidx.annotation.DrawableRes
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.navigation.Date
import com.leonardlm.habbitsapp.navigation.DateGraph
import com.leonardlm.habbitsapp.navigation.Home
import com.leonardlm.habbitsapp.navigation.Profile
import com.leonardlm.habbitsapp.navigation.Settings

data class NavigationBarItemData(
    val label: String,
    val route: Any,
    @DrawableRes val icon: Int,
)

object NavigationBarItems {
    val items = listOf(
        NavigationBarItemData(
            label = "Profile",
            route = Profile,
            icon = R.drawable.ic_launcher_foreground,
        ),
        NavigationBarItemData(
            label = "Date",
            route = DateGraph,
            icon = R.drawable.ic_launcher_foreground,
        ),
        NavigationBarItemData(
            label = "Settings",
            route = Settings,
            icon = R.drawable.ic_launcher_foreground,
        ),
    )
}