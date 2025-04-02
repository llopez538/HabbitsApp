package com.leonardlm.habbitsapp.main.domain.repository

import com.leonardlm.habbitsapp.main.models.Habit
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime

interface HomeRepository {
    fun getAllHabitsForSelectedDate(date: ZonedDateTime) : Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)
}