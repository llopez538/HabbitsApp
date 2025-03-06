package com.leonardlm.habbitsapp.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitTitle

@Composable
fun PagePaginateScreen(
    title: String,
    subtitle: String,
    image: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        HabitTitle(title.uppercase())
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.aspectRatio(1f),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(32.dp))
        DecorateParagraph(subtitle.uppercase())
    }
}