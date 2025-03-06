package com.leonardlm.habbitsapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.leonardlm.habbitsapp.authentication.login.LoginScreen
import com.leonardlm.habbitsapp.onboarding.presentation.OnboardingScreen
import kotlin.reflect.KClass

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: Any//KClass<*>?
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable<Onboarding> {
            OnboardingScreen(
                onFinish = {
                    navHostController.popBackStack()
                    navHostController.navigate(Login)
                }
            )
        }
        composable<Login> {
            LoginScreen()
        }
    }
}