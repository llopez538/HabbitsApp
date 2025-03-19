package com.leonardlm.habbitsapp.authentication.presentation.signup.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.leonardlm.habbitsapp.authentication.presentation.model.SignupState
import com.leonardlm.habbitsapp.authentication.presentation.signup.SignupEvent
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitButton
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitPasswordTextField
import com.leonardlm.habbitsapp.core.presentation.components.atoms.OutlinedTextFieldH

@Composable
fun SignupForm(
    state: SignupState,
    onEvent: (SignupEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextFieldH(
            value = state.email,
            onValueChange = { onEvent(SignupEvent.EmailChange(it)) },
            placeholder = "Email",
            contentDescription = "Enter email",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .padding(horizontal = 20.dp),
            startIcon = Icons.Outlined.Email,
            isEnable = !state.isLoading,
            isError = state.emailError != null,
            errorMessage = state.emailError,
            keyboardOptions = KeyboardOptions(
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onAny = {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            ),
            backgroundColor = Color.White
        )
        HabitPasswordTextField(
            value = state.password,
            onValueChange = { onEvent(SignupEvent.PasswordChange(it)) },
            placeholder = "Password",
            contentDescription = "Enter password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            isError = state.passwordError != null,
            errorMessage = state.passwordError,
            isEnable = !state.isLoading,
            keyboardOptions = KeyboardOptions(
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onAny = {
                    focusManager.clearFocus()
                    onEvent(SignupEvent.SignUp)
                }
            ),
            backgroundColor = Color.White
        )
        HabitButton(
            text = "Create Account",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            onEvent(SignupEvent.SignUp)
        }
        TextButton(
            onClick = { onEvent(SignupEvent.SignIn) }
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Already have an account? ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Sign In")
                    }
                },
                color = MaterialTheme.colorScheme.tertiary,
            )
        }
    }
}