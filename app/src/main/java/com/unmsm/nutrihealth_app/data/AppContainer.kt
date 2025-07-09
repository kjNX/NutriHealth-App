package com.unmsm.nutrihealth_app.data

import com.unmsm.nutrihealth_app.data.auth.AuthRepository
import com.unmsm.nutrihealth_app.data.database.DatabaseRepository
import com.unmsm.nutrihealth_app.data.messaging.MessagingRepository
import com.unmsm.nutrihealth_app.data.preferences.PreferencesRepository

interface AppContainer {
    val authRepository: AuthRepository
    val databaseRepository: DatabaseRepository
    val messagingRepository: MessagingRepository
    val preferencesRepository: PreferencesRepository
}