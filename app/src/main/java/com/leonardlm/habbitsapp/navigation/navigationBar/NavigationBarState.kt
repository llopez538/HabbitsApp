package com.leonardlm.habbitsapp.navigation.navigationBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.leonardlm.habbitsapp.navigation.Date
import com.leonardlm.habbitsapp.navigation.Home
import com.leonardlm.habbitsapp.navigation.Profile
import com.leonardlm.habbitsapp.navigation.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Stable
class NavigationBarState(private val navController: NavController) {
    @Composable
    fun isRouteSelected(route: Any): Boolean  {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination
        return currentDestination?.hierarchy?.any { it.route == route::class.qualifiedName.orEmpty() } == true
    }
    fun openRoute(route: Any) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
internal fun rememberNavigationBarState(navController: NavController): NavigationBarState {
    return remember {
        NavigationBarState(navController)
    }
}