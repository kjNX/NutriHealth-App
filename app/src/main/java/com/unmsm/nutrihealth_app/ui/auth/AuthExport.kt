package com.unmsm.nutrihealth_app.ui.auth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AuthExport(
    onSuccessfulAuth: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel()
) {
    var uiState = viewModel.uiState

    Scaffold { innerPadding ->
        AuthComposite(
            modifier = modifier.padding(innerPadding),
            isLogin = uiState.login,
            name = uiState.name,
            email = uiState.email,
            password = uiState.password,
            onNameChange = viewModel::updateName,
            onEmailChange = viewModel::updateEmail,
            onPasswordChange = viewModel::updatePassword,
            onSwitch = viewModel::toggleLogin,
            onSuccessfulAuth = onSuccessfulAuth
        )
    }
}