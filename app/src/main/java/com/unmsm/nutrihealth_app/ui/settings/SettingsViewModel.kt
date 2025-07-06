package com.unmsm.nutrihealth_app.ui.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    var uiState by mutableStateOf(SettingsUiState())

    fun updateName(name: String) { uiState = uiState.copy(name = name) }
    fun updateEmail(email: String) { uiState = uiState.copy(email = email) }
    fun updatePhoneNumber(phoneNumber: String)
    { if(phoneNumber.all { it.isDigit() }) uiState = uiState.copy(phoneNumber = phoneNumber) }
    fun toggleMeasureType(measureType: Boolean)
    { uiState = uiState.copy(measureType = measureType) }
    fun toggleNotifications(notifications: Boolean)
    { uiState = uiState.copy(notifications = notifications) }

    fun commitUserChanges() {
        TODO()
    }
}