package com.leonardlm.habbitsapp.main.domain.home.usecase

import com.leonardlm.habbitsapp.main.domain.repository.HomeRepository
import com.leonardlm.habbitsapp.main.models.Habit
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime

class GetHabitsForDateUseCase(
    private val repository: HomeRepository
) {
    operator fun invoke(date: ZonedDateTime): Flow<List<Habit>> {
        return repository.getAllHabitsForSelectedDate(date)

    }
}