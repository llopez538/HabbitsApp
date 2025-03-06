package com.leonardlm.habbitsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.leonardlm.habbitsapp.navigation.Login
import com.leonardlm.habbitsapp.navigation.NavigationHost
import com.leonardlm.habbitsapp.navigation.Onboarding
import com.leonardlm.habbitsapp.ui.theme.HabbitsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabbitsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val hasSeen = viewModel.hasSeenOnBoarding.collectAsState(initial = true)


                    NavigationHost(
                        navHostController = navController,
                        startDestination = getStartDestination(hasSeen.value)
                    )

                    Box(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun getStartDestination(hasSeenOnBoarding: Boolean?): Any {
        return when (hasSeenOnBoarding) {
            true -> Login
            false -> Onboarding
            else -> Onboarding
        }
    }
}
