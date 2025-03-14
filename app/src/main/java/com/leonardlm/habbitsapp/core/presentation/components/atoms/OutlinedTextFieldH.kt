package com.leonardlm.habbitsapp.core.presentation.components.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextFieldH(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    label: @Composable() (() -> Unit)? = null,
    placeholder: String = "",
    contentDescription: String = "",
    errorMessage: String? = "",
    isEnable: Boolean = true,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    hidePassword: Boolean = false,
    passwordVisibilityOnClick: (Boolean) -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    leadingIcon: @Composable() (() -> Unit)? = if (startIcon != null) {
        {
            Icon(
                imageVector = startIcon,
                contentDescription = contentDescription
            )
        }
    } else null,
    trailingIcon: @Composable() (() -> Unit)? = if (endIcon != null || isPassword) {
        {
            if (isPassword) {

                val msg =
                    if (hidePassword) "Show" else "Hide"

                TextButton(onClick = { passwordVisibilityOnClick(hidePassword) }
                ) {
                    Text(
                        text = msg,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            } else {
                Icon(
                    imageVector = endIcon!!,
                    contentDescription = null,
                    tint = Color(0xFF000000)
                )
            }
        }
    } else null,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = label,
            modifier = Modifier
                .fillMaxWidth()
                .semantics { this.contentDescription = contentDescription },
            placeholder = { Text(text = placeholder) },
            isError = isError,
            singleLine = true,
            enabled = isEnable,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            visualTransformation = if (isPassword && hidePassword) PasswordVisualTransformation() else VisualTransformation.None,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.primary,
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                focusedPlaceholderColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                unfocusedLeadingIconColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f)
            )
        )
        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}


@Composable
fun HabitPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    label: @Composable() (() -> Unit)? = null,
    placeholder: String = "Password",
    contentDescription: String,
    errorMessage: String? = null,
    isEnable: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    backgroundColor: Color = MaterialTheme.colorScheme.background
) {
    var passwordVisibility by rememberSaveable { mutableStateOf(true) }

    OutlinedTextFieldH(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        isError = isError,
        label = label,
        placeholder = placeholder,
        contentDescription = contentDescription,
        errorMessage = errorMessage,
        isPassword = true,
        isEnable = isEnable,
        hidePassword = passwordVisibility,
        passwordVisibilityOnClick = {
            passwordVisibility =  !passwordVisibility
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        backgroundColor = backgroundColor,
        startIcon = Icons.Outlined.Lock
    )

}
