package com.leonardlm.habbitsapp.home.di

import com.leonardlm.habbitsapp.home.data.repository.HomeRepositoryImpl
import com.leonardlm.habbitsapp.home.domain.home.usecase.CompleteHabitUseCase
import com.leonardlm.habbitsapp.home.domain.home.usecase.GetHabitsForDateUseCase
import com.leonardlm.habbitsapp.home.domain.home.usecase.HomeUseCases
import com.leonardlm.habbitsapp.home.domain.repository.HomeRepository
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