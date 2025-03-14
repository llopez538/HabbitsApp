package com.leonardlm.habbitsapp.authentication.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitButton
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitPasswordTextField
import com.leonardlm.habbitsapp.core.presentation.components.atoms.OutlinedTextFieldH

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(
                top = 12.dp,
                bottom = 22.dp,
            )
    ) {
        Text(
            text = "Log in with email",
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.tertiary
        )
        Spacer(Modifier.height(16. dp))
        HorizontalDivider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp
        )
        OutlinedTextFieldH(
            value = "",
            onValueChange = {},
            placeholder = "Email",
            contentDescription = "Enter email",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .padding(horizontal = 20.dp),
            startIcon = Icons.Outlined.Email,
            keyboardOptions = KeyboardOptions(
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onAny = {
                    //
                }
            ),
            errorMessage = null,
            isEnable = true
        )

        HabitPasswordTextField(
            value = "",
            onValueChange = {},
            placeholder = "Password",
            contentDescription = "Enter password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            errorMessage = null,
            isEnable = true,
            keyboardOptions = KeyboardOptions(
                autoCorrectEnabled = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onAny = {
                    //
                }
            )
        )

        HabitButton(
            text = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            isEnabled = true
        ) {
            /* TODO */
        }
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Forgot Password?",
                color = MaterialTheme.colorScheme.tertiary,
                textDecoration = TextDecoration.Underline
            )
        }

        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Don't have an account? ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Sign up")
                    }
                },
                color = MaterialTheme.colorScheme.tertiary,
            )
        }
    }
}

@Preview
@Composable
fun LoginFormPreview() {
    LoginForm()
}