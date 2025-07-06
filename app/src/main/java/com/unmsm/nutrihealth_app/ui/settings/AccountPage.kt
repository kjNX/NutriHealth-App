package com.unmsm.nutrihealth_app.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.shard.EnhancedTextField
import com.unmsm.nutrihealth_app.ui.shard.IndexLabel
import com.unmsm.nutrihealth_app.ui.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.shard.TitledCard

@Composable
fun PersonalInfo(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    onCommit: () -> Unit,
    modifier: Modifier = Modifier
) {
    TitledCard(
        title = "Información personal",
        icon = Icons.Default.Person,
        modifier = modifier
    ) {
        Text(text = "Nombre")
        EnhancedTextField(value = name, onValueChange = onNameChange)
        Text(text = "Correo electrónico")
        EnhancedTextField(value = email, onValueChange = onEmailChange)
        Text(text = "Teléfono")
        EnhancedTextField(value = phoneNumber, onValueChange = onPhoneNumberChange)
        LabeledButton(
            title = "Guardar cambios",
            onClick = onCommit,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SecuritySettings(
    onPasswordChangeRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    TitledCard(
        title = "Seguridad",
        icon = Icons.Default.Lock,
        modifier = modifier
    ) {
        IndexLabel(
            title = "Cambiar contraseña",
            subtitle = "Actualiza tu contraseña",
            onClick = onPasswordChangeRequest
        )
    }
}

@Composable
fun AccountPage(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    onCommit: () -> Unit,
    onPasswordChangeRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PersonalInfo(
            name = name,
            onNameChange = onNameChange,
            email = email,
            onEmailChange = onEmailChange,
            phoneNumber = phoneNumber,
            onPhoneNumberChange = onPhoneNumberChange,
            onCommit = onCommit
        )
        SecuritySettings(onPasswordChangeRequest)
    }
}
