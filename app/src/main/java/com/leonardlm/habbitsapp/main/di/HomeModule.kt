package com.leonardlm.habbitsapp.main.di

import com.leonardlm.habbitsapp.main.data.repository.HomeRepositoryImpl
import com.leonardlm.habbitsapp.main.domain.home.usecase.CompleteHabitUseCase
import com.leonardlm.habbitsapp.main.domain.home.usecase.GetHabitsForDateUseCase
import com.leonardlm.habbitsapp.main.domain.home.usecase.HomeUseCases
import com.leonardlm.habbitsapp.main.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    @Singleton
    fun provideHomeUseCases(repository: HomeRepository) : HomeUseCases {
        return HomeUseCases(
            completeHabitUseCase = CompleteHabitUseCase(repository),
            getHabitsForDateUseCase = GetHabitsForDateUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideHomeRepositoryImpl() : HomeRepository {
        return HomeRepositoryImpl()
    }
}