package com.unmsm.nutrihealth_app.ui.settings

data class SettingsUiState(
    var name: String = "",
    var email: String = "",
    var phoneNumber: String = "",
    var measureType: Boolean = false,
    var notifications: Boolean = false
)