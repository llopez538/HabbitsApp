package com.leonardlm.habbitsapp.navigation.navigationBar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.leonardlm.habbitsapp.home.presentation.main.HomeScreen
import com.leonardlm.habbitsapp.navigation.Date
import com.leonardlm.habbitsapp.navigation.DateGraph
import com.leonardlm.habbitsapp.navigation.Home
import com.leonardlm.habbitsapp.navigation.NavBarHost
import com.leonardlm.habbitsapp.navigation.Profile
import com.leonardlm.habbitsapp.navigation.Settings
import com.leonardlm.habbitsapp.navigation.datesGraph

fun NavGraphBuilder.navigationBarHost(
    navController: NavHostController,
    onLogoutClick: () -> Unit = {},
) {
    composable<NavBarHost> {
        Scaffold(
            bottomBar = {
                NavigationBarH(navController = navController)
            },
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Profile,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<Profile> {
                    Text("PROFILE")
                }
                datesGraph(navController)
                composable<Settings> {
                    Text("Settings")
                }
            }
        }
    }
}