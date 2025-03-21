package com.leonardlm.habbitsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.leonardlm.habbitsapp.authentication.presentation.login.LoginScreen
import com.leonardlm.habbitsapp.authentication.presentation.signup.SignupScreen
import com.leonardlm.habbitsapp.home.presentation.HomeScreen
import com.leonardlm.habbitsapp.onboarding.presentation.OnboardingScreen

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
            LoginScreen(
                onLogin = {
                    navHostController.popBackStack()
                    navHostController.navigate(Home)
                },
                onSignUp = {
                    navHostController.navigate(SignUp)
                }
            )
        }
        composable<SignUp> {
            SignupScreen(
                onSignIn = {
                    navHostController.navigate(Home) {
                        popUpTo(navHostController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                onLogIn = {
                    navHostController.popBackStack()
                }
            )
        }
        composable<Home> {
            HomeScreen()
        }

    }
}