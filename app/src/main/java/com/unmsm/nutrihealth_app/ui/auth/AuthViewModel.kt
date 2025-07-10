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
import com.unmsm.nutrihealth_app.model.live.User
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository,
    private val databaseRepository: DatabaseRepository
) : ViewModel() {
    var uiState by mutableStateOf(AuthUiState())

    fun toggleLogin() { uiState = uiState.copy(login = !uiState.login) }
    fun updateName(name: String) { uiState = uiState.copy(name = name) }
    fun updateEmail(email: String) { uiState = uiState.copy(email = email) }
    fun updatePassword(password: String) { uiState = uiState.copy(password = password) }

    fun login(email: String, password: String) {
        uiState = uiState.copy(status = AuthUiState.Status.LOADING)
        viewModelScope.launch {
            try {
                val authSuccess = authRepository.login(email, password)

                if (authSuccess) {
                    val authId = authRepository.currentSession

                    if (authId != null) {
                        val user = databaseRepository.getUser(authId)
                        if(user != null) uiState = uiState.copy(
                            status = AuthUiState.Status.SUCCESS,
                            errorMessage = "Signing in as ${user.name}..."
                        ) else uiState.copy(
                            status = AuthUiState.Status.FAILED,
                            errorMessage = "User has been blocked. Contact the sysadmin for more information."
                        )
                    } else {
                        uiState = uiState.copy(
                            status = AuthUiState.Status.FAILED,
                            errorMessage = "Auth successful but user data missing for DB."
                        )
                    }
                } else {
                    uiState = uiState.copy(
                        status = AuthUiState.Status.FAILED,
                        errorMessage = "Login failed. Please check your credentials."
                    )
                }
            } catch (e: Exception) {
                uiState = uiState.copy(
                    status = AuthUiState.Status.FAILED,
                    errorMessage = "An error occurred: ${e.localizedMessage ?: "Unknown error"}"
                )
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        uiState = uiState.copy(status = AuthUiState.Status.LOADING)
        viewModelScope.launch {
            try {
                val authSuccess = authRepository.register(email, password)

                if (authSuccess) {
                    val authId = authRepository.currentSession

                    if (authId != null) {
                        val user = User(authId, name)
                        databaseRepository.setUser(authId, user)
                        uiState = uiState.copy(status = AuthUiState.Status.SUCCESS)
                    } else {
                        uiState = uiState.copy(
                            status = AuthUiState.Status.FAILED,
                            errorMessage = "Auth successful but user data missing for DB."
                        )
                    }

                } else {
                    uiState = uiState.copy(
                        status = AuthUiState.Status.FAILED,
                        errorMessage = "Registration failed."
                    )
                }
            } catch (e: Exception) {
                uiState = uiState.copy(
                    status = AuthUiState.Status.FAILED,
                    errorMessage = "An error occurred: ${e.localizedMessage ?: "Unknown error"}"
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NutriHealthApp)
                val authRepository = application.container.authRepository
                val databaseRepository = application.container.databaseRepository
                AuthViewModel(authRepository, databaseRepository)
            }
        }
    }
}