package com.leonardlm.habbitsapp.onboarding.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leonardlm.habbitsapp.utils.Helper.Companion.splitTextWithAsteriskIdentification

@Composable
fun DecorateParagraph(paragraph: String) {
    val separateSentence = splitTextWithAsteriskIdentification(paragraph)
    Text(
        text = buildAnnotatedString {
            separateSentence.forEach { (text, isAsterisk) ->
                if (isAsterisk) {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 16.sp
                        )
                    ) {
                        append(text)
                    }
                } else {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 16.sp
                        )
                    ) {
                        append(text)
                    }
                }
            }
        },
        fontSize = 16.sp,
        modifier = Modifier.padding(16.dp)
    )
}