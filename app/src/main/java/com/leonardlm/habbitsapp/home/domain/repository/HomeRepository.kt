package com.leonardlm.habbitsapp.home.domain.repository

import com.leonardlm.habbitsapp.home.models.Habit
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime

interface HomeRepository {
    fun getAllHabitsForSelectedDate(date: ZonedDateTime) : Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)
}