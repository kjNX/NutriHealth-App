package com.unmsm.nutrihealth_app.data.auth

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

const val TAG = "FirebaseAuthRepository"

class FirebaseAuthRepository : AuthRepository {
    private val instance = FirebaseAuth.getInstance()

    override val currentSession
        get() = instance.currentUser?.uid ?: ""

    override suspend fun login(email: String, password: String) : Boolean {
        return try {
            instance.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            Log.d(TAG, "login: ${e.message}")
            false
        }
    }

    override suspend fun register(email: String, password: String) : Boolean {
        return try {
            instance.createUserWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            Log.d(TAG, "register: ${e.message}")
            false
        }
    }

    override fun logout() { instance.signOut() }

    override suspend fun delete() : Boolean {
        return try {
            instance.currentUser?.delete()?.await()
            true
        } catch (e: Exception) {
            Log.d(TAG, "delete: ${e.message}")
            false
        }
    }
}
