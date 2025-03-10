package com.leonardlm.habbitsapp.authentication.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.authentication.login.components.LoginForm
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitTitle

@Composable
fun LoginScreen() {
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
                HabitTitle("Welcome to \nMonumental habits")
                LoginForm()
            }
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}