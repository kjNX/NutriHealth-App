package com.unmsm.nutrihealth_app.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.shard.EnhancedTextField
import com.unmsm.nutrihealth_app.ui.shard.IconButton
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
        TextButton(onSwitch, contentPadding = PaddingValues()) {
            Text(if(isLogin) "¡Regístrate ahora! ¡Es gratis!" else "¡Inicia sesión ahora!")
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
private fun Preview() {
    AuthScreen()
}
*/
