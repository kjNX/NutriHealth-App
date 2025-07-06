package com.unmsm.nutrihealth_app.data.preferences

interface PreferencesRepository {
    suspend fun getValue()
    suspend fun setValue()
}