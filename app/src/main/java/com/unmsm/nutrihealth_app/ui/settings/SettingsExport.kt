package com.unmsm.nutrihealth_app.ui.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SettingsExport(modifier: Modifier = Modifier, viewModel: SettingsViewModel = viewModel()) {
    var uiState = viewModel.uiState

    Scaffold { innerPadding ->
        SettingsComposite(
            name = uiState.name,
            onNameChange = viewModel::updateName,
            email = uiState.email,
            onEmailChange = viewModel::updateEmail,
            phoneNumber = uiState.phoneNumber,
            onPhoneNumberChange = viewModel::updatePhoneNumber,
            onCommit = viewModel::commitUserChanges,
            onPasswordChangeRequest = { TODO() },
            measureType = uiState.measureType,
            onMeasureTypeToggle = viewModel::toggleMeasureType,
            notifications = uiState.notifications,
            onNotificationsToggle = viewModel::toggleNotifications,
            onExportRequest = { TODO() },
            onDeleteRequest = { TODO() },
            onLogout = { TODO() },
            modifier = modifier.padding(innerPadding)
        )
    }
}