package com.unmsm.nutrihealth_app.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var uiState by mutableStateOf(AuthUiState())

    fun toggleLogin() { uiState = uiState.copy(login = !uiState.login) }
    fun updateName(name: String) { uiState = uiState.copy(name = name) }
    fun updateEmail(email: String) { uiState = uiState.copy(email = email) }
    fun updatePassword(password: String) { uiState = uiState.copy(password = password) }
}