package com.unmsm.nutrihealth_app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unmsm.nutrihealth_app.R
import com.unmsm.nutrihealth_app.ui.screen.shard.EnhancedTextField
import com.unmsm.nutrihealth_app.ui.screen.shard.IconButton
import com.unmsm.nutrihealth_app.ui.screen.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.viewmodel.AuthViewModel
import com.unmsm.nutrihealth_app.util.icon.Facebook
import com.unmsm.nutrihealth_app.util.icon.Google

val icons = listOf(Facebook, Google)
val loginName = listOf("Facebook", "Google")
val onLoginSelect = listOf({}, {})

@Composable
fun AnotherLoginRow(
    icons: List<ImageVector>,
    loginName: List<String?>,
    onLoginSelect: List<() -> Unit>,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Continuar con")
        for(i in 0..<icons.size) {
            IconButton(
                icon = icons[i],
                contentDescription = "Continuar con ${loginName[i]}",
                onClick = onLoginSelect[i]
            )
        }
    }
}

@Composable
fun LoginInformationColumn(
    isLogin: Boolean,
    name: String,
    email: String,
    password: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        if(!isLogin) {
            Text(text = "Nombre")
            EnhancedTextField(
                value = name,
                onValueChange = onNameChange
            )
            Spacer(Modifier.height(8.dp))
        }
        Text(text = "Correo electrónico")
        EnhancedTextField(
            value = email,
            onValueChange = onEmailChange
        )
        Spacer(Modifier.height(8.dp))
        Text(text = "Contraseña")
        EnhancedTextField(
            value = password,
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun LoginSelect(isLogin: Boolean, onSwitch: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(if(isLogin) "¿No tienes una cuenta? " else "¿Tienes una cuenta? ")
        TextButton({}, contentPadding = PaddingValues()) {
            Text(if(isLogin) "¡Regístrate ahora! ¡Es gratis!" else "¡Inicia sesión ahora!")
        }
    }
}

@Composable
fun AuthScreen(
    onSuccessfulAuth: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel()
) {
    val state = viewModel.uiState

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
            isLogin = state.login,
            name = state.name,
            email = state.email,
            password = state.password,
            onNameChange = viewModel::updateName,
            onEmailChange = viewModel::updateEmail,
            onPasswordChange = viewModel::updatePassword
        )
        Spacer(Modifier.height(8.dp))
        LabeledButton(
            title = "Iniciar sesión",
            onClick = {
                onSuccessfulAuth()
            }
        )
        AnotherLoginRow(icons, loginName, onLoginSelect)
        LoginSelect(state.login, viewModel::toggleLogin)
    }
}

/*
@Preview(showBackground = true)
@Composable
private fun Preview() {
    AuthScreen()
}
*/
