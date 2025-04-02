package com.leonardlm.habbitsapp.main.presentation.home

import com.leonardlm.habbitsapp.main.models.Habit
import java.time.ZonedDateTime

data class HomeState(
    val currentDate: ZonedDateTime = ZonedDateTime.now(),
    val selectedDate: ZonedDateTime = ZonedDateTime.now(),
    val habits: List<Habit> = emptyList()
)

