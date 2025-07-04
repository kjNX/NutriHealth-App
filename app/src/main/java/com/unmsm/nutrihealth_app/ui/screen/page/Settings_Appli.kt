package com.unmsm.nutrihealth_app.ui.screen.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.screen.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.screen.shard.LabeledSwitch
import com.unmsm.nutrihealth_app.ui.screen.shard.TitledCard

@Composable
fun Preferences(modifier: Modifier = Modifier) {
    TitledCard(title = "Preferencias", modifier = modifier) {
        LabeledSwitch(
            title = "Unidades",
            subtitle = "La aplicación utilizará cm y kg",
            checked = true,
            onCheckedChange = {}
        )
        LabeledSwitch(
            title = "Notificaciones",
            subtitle = "Las notificaciones están habilitadas",
            checked = true,
            onCheckedChange = {}
        )
    }
}

@Composable
fun DataChoices(modifier: Modifier = Modifier) {
    TitledCard(
        title = "Datos del usuario",
        modifier = modifier
    ) {
        LabeledButton(
            title = "Exportar informe",
            onClick = {},
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.fillMaxWidth()
        )
        LabeledButton(
            title = "Eliminar cuenta",
            onClick = {},
            icon = Icons.Default.Delete,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AppliSettings(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Preferences()
        DataChoices()
        LabeledButton(
            title = "Cerrar sesión",
            onClick = {},
            icon = Icons.AutoMirrored.Filled.ExitToApp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
