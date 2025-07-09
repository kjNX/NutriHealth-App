package com.unmsm.nutrihealth_app.data

import com.unmsm.nutrihealth_app.data.auth.AuthRepository
import com.unmsm.nutrihealth_app.data.auth.FirebaseAuthRepository
import com.unmsm.nutrihealth_app.data.database.DatabaseRepository
import com.unmsm.nutrihealth_app.data.database.FirestoreRepository
import com.unmsm.nutrihealth_app.data.messaging.GeminiMessagingRepository
import com.unmsm.nutrihealth_app.data.messaging.MessagingRepository
import com.unmsm.nutrihealth_app.data.preferences.LocalPreferencesRepository
import com.unmsm.nutrihealth_app.data.preferences.PreferencesRepository

class DefaultAppContainer : AppContainer {
    override val authRepository: AuthRepository = FirebaseAuthRepository()
    override val databaseRepository: DatabaseRepository = FirestoreRepository()
    override val messagingRepository: MessagingRepository = GeminiMessagingRepository()
    override val preferencesRepository: PreferencesRepository = LocalPreferencesRepository()
}