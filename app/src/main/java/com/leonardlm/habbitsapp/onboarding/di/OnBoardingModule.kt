package com.leonardlm.habbitsapp.onboarding.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.leonardlm.habbitsapp.onboarding.data.repository.OnBoardingRepositoryImpl
import com.leonardlm.habbitsapp.onboarding.data.soruce.local.OnBoardingStoreManager
import com.leonardlm.habbitsapp.onboarding.domain.repository.OnBoardingRepository
import com.leonardlm.habbitsapp.onboarding.domain.usecase.CompleteOnBoardingUseCase
import com.leonardlm.habbitsapp.onboarding.domain.usecase.HasSeenOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object OnBoardingModule {
    @Provides
    @Singleton
    fun provideDataStorePreferences(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile("onboarding_preferences")
            }
        )
    }

    @Provides
    @Singleton
    fun provideOnBoardingRepository(dataStore: DataStore<Preferences>): OnBoardingStoreManager {
        return  OnBoardingStoreManager(dataStore)
    }

    @Provides
    @Singleton
    fun provideOnBoardingRepositoryImpl(settingsDataStore: OnBoardingStoreManager): OnBoardingRepository {
        return OnBoardingRepositoryImpl(settingsDataStore)
    }

    @Provides
    @Singleton
    fun provideHasSeenOnboardingUseCase(repository: OnBoardingRepository) : HasSeenOnBoardingUseCase {
        return HasSeenOnBoardingUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCompleteOnboardingUseCase(repository: OnBoardingRepository): CompleteOnBoardingUseCase {
        return CompleteOnBoardingUseCase(repository)
    }
}
