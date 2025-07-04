package com.unmsm.nutrihealth_app.ui.screen.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.screen.shard.EnhancedTextField
import com.unmsm.nutrihealth_app.ui.screen.shard.IndexLabel
import com.unmsm.nutrihealth_app.ui.screen.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.screen.shard.TitledCard

@Composable
fun PersonalInfo(modifier: Modifier = Modifier) {
    TitledCard(
        title = "Información personal",
        icon = Icons.Default.Person,
        modifier = modifier
    ) {
        Text(text = "Nombre")
        EnhancedTextField(value = "", onValueChange = {})
        Text(text = "Correo electrónico")
        EnhancedTextField(value = "", onValueChange = {})
        Text(text = "Teléfono")
        EnhancedTextField(value = "", onValueChange = {})
        LabeledButton(
            title = "Guardar cambios",
            onClick = {},
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
fun AccountSettings(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PersonalInfo()
        SecuritySettings({})
    }
}
