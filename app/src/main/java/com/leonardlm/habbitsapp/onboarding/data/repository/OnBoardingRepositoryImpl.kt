package com.leonardlm.habbitsapp.onboarding.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.leonardlm.habbitsapp.onboarding.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnBoardingRepositoryImpl constructor(
    private val context: Context
): OnBoardingRepository {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("onboarding_preferences")
        val HAS_SEEN_ONBOARDING = booleanPreferencesKey("has_seen_onboarding")
    }

    override fun hasSeenOnBoarding(): Flow<Boolean?> {
        return context.dataStore.data.map { preferences ->
            preferences[HAS_SEEN_ONBOARDING] ?: return@map null
        }
    }

    override suspend fun completeOnBoarding() {
        context.dataStore.edit { preferences ->
            preferences[HAS_SEEN_ONBOARDING] = true
        }
    }

}
