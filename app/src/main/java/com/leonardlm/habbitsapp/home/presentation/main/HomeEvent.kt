package com.leonardlm.habbitsapp.home.presentation.main

import com.leonardlm.habbitsapp.home.models.Habit
import java.time.ZonedDateTime

sealed interface HomeEvent {
    data class ChangeDate(val date: ZonedDateTime): HomeEvent
    data class CompletedHabit(val habit: Habit): HomeEvent
}