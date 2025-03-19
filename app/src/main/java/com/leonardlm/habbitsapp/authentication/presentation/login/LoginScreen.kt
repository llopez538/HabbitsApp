package com.leonardlm.habbitsapp.authentication.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.authentication.presentation.login.components.LoginForm
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitTitle

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    onLogin: () -> Unit,
    onSignUp: () -> Unit
) {
    val state = loginViewModel.state
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = state.isLoggedIn) {
        if (state.isLoggedIn) {
            onLogin()
        }
    }

    LaunchedEffect(state.sigUp) {
        if (state.sigUp) {
            onSignUp()
        }
    }

    LaunchedEffect(key1 = state.serverError) {
        if (state.serverError != null) {
            snackBarHostState.showSnackbar(state.serverError)
        }
    }

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val colors = listOf(
                    Color.Transparent,
                    MaterialTheme.colorScheme.background,
                    MaterialTheme.colorScheme.background
                )
                Image(
                    painter = painterResource(R.drawable.loginbackground),
                    contentDescription = "Login background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1F)
                        .graphicsLayer(
                            scaleX = 1.27F,
                            scaleY = 1.27F
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            verticalGradient(
                                colors = colors,
                                startY = 0f,
                                endY = Float.POSITIVE_INFINITY
                            )
                        )
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Spacer(Modifier.weight(1f))
                    HabitTitle("Welcome to \nMonumental habits",)
                    Spacer(Modifier.weight(1f))
                    LoginForm(
                        state = state,
                        onEvent = loginViewModel::onEvent
                    )
                }
            }

        }

        if (state.serverError != null) {
            SnackbarHost(snackBarHostState) {
                Snackbar(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text(text = state.serverError)
                }
            }

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLogin = {},
        onSignUp = {},
    )
}