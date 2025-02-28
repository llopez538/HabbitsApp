package com.leonardlm.habbitsapp.onboarding.data.soruce.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OnBoardingStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("onboarding_preferences")
        val HAS_SEEN_ONBOARDING = booleanPreferencesKey("has_seen_onboarding")
    }

    fun hasSeenOnboarding(): Flow<Boolean?> {
        return dataStore.data.map { preferences ->
            preferences[HAS_SEEN_ONBOARDING] ?: return@map null
        }
    }

    suspend fun completeHasSeenOnboarding() {
        dataStore.edit { preferences ->
            preferences[HAS_SEEN_ONBOARDING] = true
        }
    }
}