package com.leonardlm.habbitsapp.core.presentation.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HabitCheckBox(
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(35.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable { onCheckedChange() }
    ) {
        if (isChecked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Checked",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HabitCheckBoxPreview() {
    Column(
        modifier = Modifier.background(Color.Blue)
    ) {
        HabitCheckBox(
            isChecked = true,
            onCheckedChange = {}
        )

        HabitCheckBox(
            isChecked = false,
            onCheckedChange = {}
        )

    }
}