package com.leonardlm.habbitsapp.authentication.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.authentication.presentation.model.SignupState
import com.leonardlm.habbitsapp.authentication.presentation.signup.components.SignupForm
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitTitle

@Composable
fun SignupScreen(
    signupViewModel: SignupViewModel = hiltViewModel(),
    onSignUp: () -> Unit,
    onSignIn: () -> Unit
) {
    val state = signupViewModel.state

    Scaffold { innerPadding ->
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

@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen(
        onSignUp = {},
        onSignIn = {}
    )
}