package com.unmsm.nutrihealth_app.ui.screen.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.screen.shard.EnhancedTextField
import com.unmsm.nutrihealth_app.ui.screen.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.screen.shard.RadioGroup

val goalOptions = listOf("Mejorar salud", "Bajar de peso", "Ganar músculo")

@Composable
fun TargetData(
    targetWeight: String,
    mainGoal: Int,
    onWeightChange: (String) -> Unit,
    onGoalChange: (Int) -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Detalles de objetivo", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Define tu meta específica")
        Text(text = "Peso objetivo", modifier = Modifier.padding(vertical = 8.dp))
        EnhancedTextField(value = targetWeight, onValueChange = onWeightChange, placeholder = "kg")
        Text(text = "Meta principal", modifier = Modifier.padding(vertical = 8.dp))
        RadioGroup(mainGoal, goalOptions, onGoalChange)
        Spacer(Modifier.height(8.dp))
        LabeledButton("Continuar", onNext, Modifier.fillMaxWidth())
    }
}
