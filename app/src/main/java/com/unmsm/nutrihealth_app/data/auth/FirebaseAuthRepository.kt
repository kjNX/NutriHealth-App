package com.unmsm.nutrihealth_app.data.auth

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository : AuthRepository {
    private val instance = FirebaseAuth.getInstance()

    override val currentSession
        get() = instance.currentUser?.uid ?: ""

    override suspend fun login(email: String, password: String, onReturn: (Boolean) -> Unit) {
        instance.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { onReturn(it.isSuccessful) }
    }

    override suspend fun register(email: String, password: String, onReturn: (Boolean) -> Unit) {
        instance.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { onReturn(it.isSuccessful) }
    }

    override fun logout() { instance.signOut() }

    override suspend fun delete(onReturn: (Boolean) -> Unit) {
        instance.currentUser?.delete()?.addOnCompleteListener { onReturn(it.isSuccessful) }
    }
}
