package com.leonardlm.habbitsapp.authentication.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.authentication.presentation.model.SignupState
import com.leonardlm.habbitsapp.authentication.presentation.signup.components.SignupForm
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitTitle

@Composable
fun SignupScreen(
    signupViewModel: SignupViewModel = hiltViewModel(),
    onSignIn: () -> Unit,
    onLogIn: () -> Unit
) {
    val state = signupViewModel.state
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = state.logIn) {
        if (state.logIn) {
            onLogIn()
        }
    }

    LaunchedEffect(key1 = state.isSignedIn) {
        if (state.isSignedIn) {
            onSignIn()
        }
    }

    LaunchedEffect(key1 = state.serverError) {
        if (state.serverError != null) {
            snackBarHostState.showSnackbar(state.serverError)
        }
    }

    LaunchedEffect(key1 = state.success) {
        if (state.success != null) {
            snackBarHostState.showSnackbar(state.success)
        }
    }

    Scaffold(
        snackbarHost = {
            if (state.serverError != null || state.success != null) {
                SnackbarHost(hostState = snackBarHostState) {
                    Snackbar(
                        containerColor = containerColor(state),
                        modifier = Modifier.padding(16.dp),
                        snackbarData = it,
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(R.drawable.signup),
                contentDescription = "Login background"
            )
            HabitTitle(title = "Create your Account")
            SignupForm(
                state = state,
                onEvent = signupViewModel::onEvent
            )
        }

    }
}

@Composable
fun containerColor(state: SignupState): Color {
    var color: Color = SnackbarDefaults.color
    if (state.serverError != null) {
        color = MaterialTheme.colorScheme.error
    }
    if (state.success != null) {
        color = MaterialTheme.colorScheme.primary
    }
    return color
}

@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen(
        onLogIn = {},
        onSignIn = {}
    )
}