package com.leonardlm.habbitsapp.authentication.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.authentication.presentation.model.SignupState
import com.leonardlm.habbitsapp.authentication.presentation.signup.components.SignupForm
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitButton
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitPasswordTextField
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitTitle
import com.leonardlm.habbitsapp.core.presentation.components.atoms.OutlinedTextFieldH

@Composable
fun SignupScreen() {
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
                state = SignupState(),
                onEvent = {}
            )
        }

    }
}

@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen()
}