package com.leonardlm.habbitsapp.onboarding.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.leonardlm.habbitsapp.utils.Helper.Companion.splitTextWithAsteriskIdentification

@Composable
fun DecorateParagraph(
    paragraph: String
) {
    val separateSentence = splitTextWithAsteriskIdentification(paragraph)
    Text(
        text = buildAnnotatedString {
            separateSentence.forEach { (text, isAsterisk) ->
                if (isAsterisk) {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        append(text)
                    }
                } else {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    ) {
                        append(text)
                    }
                }
            }
        },
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        ),
        modifier = Modifier
    )
}