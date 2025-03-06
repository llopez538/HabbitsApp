package com.leonardlm.habbitsapp.authentication.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(
                top = 12.dp,
                bottom = 22.dp,
                start = 0.dp,
                end = 0.dp
            )

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Log in with email")
            Spacer(Modifier.height(16. dp))
            HorizontalDivider(
                color = MaterialTheme.colorScheme.background,
                thickness = 1.dp
            )
        }

    }
}

@Preview
@Composable
fun LoginFormPreview() {
    LoginForm()
}