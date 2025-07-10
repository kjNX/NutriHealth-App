package com.unmsm.nutrihealth_app.ui.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.R
import com.unmsm.nutrihealth_app.ui.shard.LabeledButton

@Composable
fun AuthComposite(
    status: AuthUiState.Status,
    isLogin: Boolean,
    name: String,
    email: String,
    password: String,
    errorMessage: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSwitch: () -> Unit,
    onLogin: (String, String) -> Unit,
    onRegister: (String, String, String) -> Unit,
    onSuccessfulAuth: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LaunchedEffect(status) {
        when(status) {
            AuthUiState.Status.NONE -> {}
            AuthUiState.Status.LOADING -> Toast.makeText(
                context,
                "Cargando...",
                Toast.LENGTH_SHORT
            )
                .show()
            AuthUiState.Status.FAILED -> Toast.makeText(
                context,
                errorMessage,
                Toast.LENGTH_SHORT
            ).show()
            AuthUiState.Status.SUCCESS -> {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                onSuccessfulAuth()
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo_nutrihealth),
            contentDescription = null,
            modifier = Modifier
                .width(96.dp)
        )
        Text(
            text = "Bienvenido a NutriHealth",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        LoginInformationColumn(
            isLogin = isLogin,
            name = name,
            email = email,
            password = password,
            onNameChange = onNameChange,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange
        )
        Spacer(Modifier.height(8.dp))
        LabeledButton(
            title = if(isLogin) "Iniciar sesión" else "Registrarse",
            onClick = { if(isLogin) onLogin(email, password) else onRegister(name, email, password) }
        )
        AnotherLoginRow(icons, loginName, onLoginSelect)
        LoginSelect(isLogin, onSwitch)
    }
}
