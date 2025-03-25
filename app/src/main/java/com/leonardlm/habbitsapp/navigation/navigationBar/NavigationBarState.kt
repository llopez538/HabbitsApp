package com.leonardlm.habbitsapp.navigation.navigationBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NavigationBarState(private val navController: NavController) {
    fun isRouteSelected(route: Any): Flow<Boolean>  {
        return navController.currentBackStack.map { backStack ->
            backStack.any {
                it.destination.route == route
            }
        }
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