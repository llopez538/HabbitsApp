package com.leonardlm.habbitsapp.main.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.ZonedDateTime

@Composable
fun HomeDateSelector(
    selectedDate: ZonedDateTime,
    mainDate: ZonedDateTime,
    onDateClick: (ZonedDateTime) -> Unit,
    modifier: Modifier = Modifier,
    datesToShow: Int = 4
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        for (i in datesToShow downTo 0) {
            val date = mainDate.minusDays(i.toLong())
            HomeDateItem(
                date = date,
                selected = date.toLocalDate() == selectedDate.toLocalDate(),
                onClick = {
                    onDateClick(date)
                }
            )
        }
    }
}