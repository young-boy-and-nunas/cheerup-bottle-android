package com.example.uniton4.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class LocalRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        private const val DATASTORE_NAME = "auth_key"
        private val ACCESS_KEY = stringPreferencesKey("access_key")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)

    fun getUserKey(): Flow<String?> {
        return context.dataStore.data
            .catch {
                if (it is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { preferences ->
                preferences[ACCESS_KEY]
            }
    }

    suspend fun setUserKey(key: String) {
        context.dataStore.edit { preferences ->
            preferences[ACCESS_KEY] = key
        }
    }

}
