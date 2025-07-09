package com.unmsm.nutrihealth_app.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.unmsm.nutrihealth_app.NutriHealthApp
import com.unmsm.nutrihealth_app.data.auth.AuthRepository
import com.unmsm.nutrihealth_app.data.database.DatabaseRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    var uiState by mutableStateOf(AuthUiState())

    fun toggleLogin() { uiState = uiState.copy(login = !uiState.login) }
    fun updateName(name: String) { uiState = uiState.copy(name = name) }
    fun updateEmail(email: String) { uiState = uiState.copy(email = email) }
    fun updatePassword(password: String) { uiState = uiState.copy(password = password) }

    fun login(email: String, password: String) {
        uiState = uiState.copy(status = AuthUiState.Status.LOADING)
        viewModelScope.launch {
            authRepository.login(email, password) {
                uiState = uiState.copy(
                    status = if(it) AuthUiState.Status.SUCCESS else AuthUiState.Status.FAILED
                )
            }
        }
    }

    fun register(email: String, password: String) {
        uiState = uiState.copy(status = AuthUiState.Status.LOADING)
        viewModelScope.launch {
            authRepository.register(email, password) {
                uiState = uiState.copy(
                    status = if(it) AuthUiState.Status.SUCCESS else AuthUiState.Status.FAILED
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NutriHealthApp)
                val repository = application.container.authRepository
                AuthViewModel(repository)
            }
        }
    }
}