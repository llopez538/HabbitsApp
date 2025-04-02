package com.leonardlm.habbitsapp.main.presentation.home

import com.leonardlm.habbitsapp.main.models.Habit
import java.time.ZonedDateTime

sealed interface HomeEvent {
    data class ChangeDate(val date: ZonedDateTime): HomeEvent
    data class CompletedHabit(val habit: Habit): HomeEvent
}