package com.unmsm.nutrihealth_app.ui.setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.shard.EnhancedTextField
import com.unmsm.nutrihealth_app.ui.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.shard.WideButtonGroup

val genderList = listOf("Hombre", "Mujer") // Solo hay 2 (^_^)

@Composable
fun EssentialPage(
    genderIndex: Int,
    intensity: Float,
    age: String,
    height: String,
    weight: String,
    onGenderChange: (Int) -> Unit,
    onAgeChange: (String) -> Unit,
    onHeightChange: (String) -> Unit,
    onWeightChange: (String) -> Unit,
    onIntensityChange: (Float) -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Datos personales", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Información básica para calcular tus necesidades")
        Text(text = "Género", modifier = Modifier.padding(vertical = 8.dp))
        WideButtonGroup(genderIndex, genderList, onGenderChange)
        Text(text = "Edad actual", modifier = Modifier.padding(vertical = 8.dp))
        EnhancedTextField(age, onAgeChange)
        Text(text = "Altura actual", modifier = Modifier.padding(vertical = 8.dp))
        EnhancedTextField(height, onHeightChange, placeholder = "cm")
        Text(text = "Peso actual", modifier = Modifier.padding(vertical = 8.dp))
        EnhancedTextField(weight, onWeightChange, placeholder = "kg")
        Text(text = "Intensidad de actividad física", modifier = Modifier.padding(vertical = 8.dp))
        Slider(
            value = intensity,
            valueRange = 0f..8f,
            steps = 7,
            onValueChange = onIntensityChange
        )
        Spacer(Modifier.height(8.dp))
//        Button(onClick = onNext, modifier = Modifier.fillMaxWidth()) { Text(text = "Continuar") }
        LabeledButton("Continuar", onNext, modifier = Modifier.fillMaxWidth())
    }
}
