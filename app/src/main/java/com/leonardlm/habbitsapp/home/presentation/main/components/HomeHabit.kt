package com.leonardlm.habbitsapp.home.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitCheckBox
import com.leonardlm.habbitsapp.home.models.Habit
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime

@Composable
fun HomeHabit(
    habit: Habit,
    selectedDate: LocalDate,
    onCheckedChange: () -> Unit,
    onHabitClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(
                topStart = 12.dp,
                bottomStart = 12.dp))
            .background(Color.White)
            .clickable { TODO() }
            .padding(19.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = habit.name,
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        HabitCheckBox(
            isChecked = habit.completedDates.contains(selectedDate),
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview
@Composable
fun HomeHabitPreview() {
    HomeHabit(
        habit = Habit(
            id = "1",
            name = "Habit 1",
            frequency = listOf(),
            completedDates = listOf(),
            reminder = LocalTime.now(),
            startDate = ZonedDateTime.now()
        ),
        selectedDate = LocalDate.now(),
        onCheckedChange = {},
        onHabitClick = {}
    )
}