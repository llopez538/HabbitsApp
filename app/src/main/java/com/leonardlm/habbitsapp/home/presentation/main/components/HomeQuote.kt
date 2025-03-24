package com.leonardlm.habbitsapp.home.presentation.main.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeQuote(
    text: String,
    author: String,
    @DrawableRes imageId: Int,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .height(146.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Home quote",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .graphicsLayer(
                    scaleX = 2.48F,
                    scaleY = 2.478F)
                .offset(
                    x = (-14).dp,
                    y = 27.dp
                )

        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 26.dp,
                    start = 16.dp,
                    end = 100.dp
                )
                .align(Alignment.TopStart),
        ) {
            Text(
                text = text.uppercase(),
                modifier = Modifier.padding(bottom = 4.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 16.sp,
                style = LocalTextStyle.current.merge(
                    TextStyle(
                        lineHeight = 20.5.sp
                    )
                )
            )
            Text(
                text = "- ${author.uppercase()}",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary.copy(
                    alpha = 0.5f
                ),
                fontSize = 12.sp
            )
        }
    }
}