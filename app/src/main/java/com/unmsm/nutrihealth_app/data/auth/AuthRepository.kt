package com.unmsm.nutrihealth_app.data.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthRepository {
    val currentSession : String? // returns the uid of the current session or an empty string

    suspend fun login(email: String, password: String, onReturn: (Boolean) -> Unit)
    suspend fun register(email: String, password: String, onReturn: (Boolean) -> Unit)
    fun logout()
    suspend fun delete(onReturn: (Boolean) -> Unit)
}