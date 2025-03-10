package com.leonardlm.habbitsapp.core.presentation.components.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import java.lang.Error

@Composable
fun OutlinedTextFieldH(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    label: @Composable() (() -> Unit)?,
    placeholder: String,
    contentDescription: String,
    errorMessage: String,
    isEnable: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    passwordVisibility: Boolean = false,
    passwordVisibilityOnClick: (Boolean) -> Unit = {},
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    leadingIcon: @Composable() (() -> Unit)? = if (startIcon != null)  {
        {
            Icon(
                imageVector = startIcon,
                contentDescription = contentDescription
            )
        }
    } else null,
    trailingIcon: @Composable() (() -> Unit)? = if (endIcon != null || keyboardType.toString() == KeyboardType.Password.toString()) {
        {
            if (keyboardType.toString() == KeyboardType.Password.toString()) {

                val msg =
                    if (passwordVisibility) "Hide" else "Show"

                IconButton(onClick = { passwordVisibilityOnClick(passwordVisibility) }
                ) {
                    Icon(
                        imageVector = endIcon!!,
                        contentDescription = null
                    )
                    Text(
                        text = msg,
                        color = Color.Red
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
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = label,
            modifier = modifier
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
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
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

