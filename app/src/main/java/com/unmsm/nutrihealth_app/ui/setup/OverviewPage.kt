package com.unmsm.nutrihealth_app.ui.setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.shard.ValueCard

@Composable
fun NutrientDistribution(
    protein: Int,
    carbs: Int,
    fats: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        ValueCard(
            title = "Proteínas",
            percentage = 30,
            amount = protein,
            bgColor = Color(0xFF9CCC65), // verde claro
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.width(8.dp))
        ValueCard(
            title = "Carbohidratos",
            percentage = 45,
            amount = carbs,
            bgColor = Color(0xFFFFF176), // amarillo suave
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.width(8.dp))
        ValueCard(
            title = "Grasas",
            percentage = 25,
            amount = fats,
            bgColor = Color(0xFFE57373), // rojo rosado
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun OverviewPage(
    tmb: Int,
    recommendedKcal: Int,
    protein: Int,
    carbs: Int,
    fats: Int,
    timeToReach: Int,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Resumen y análisis", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Basado en tus datos, hemos calculado lo siguiente")
        Text(text = "Metabolismo basal", modifier = Modifier.padding(vertical = 8.dp))
        Text(text = "$tmb kcal", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Cantidad de calorías recomendada", modifier = Modifier.padding(vertical = 8.dp))
        Text(text = "$recommendedKcal kcal", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Distribución de macronutrientes", modifier = Modifier.padding(vertical = 8.dp))
        NutrientDistribution(protein, carbs, fats)
        Text(text = "Tiempo estimado para alcanzar su objetivo", modifier = Modifier.padding(vertical = 8.dp))
        Text(text = "$timeToReach semanas", style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "Al hacer clic en \"Comenzar a utilizar NutriHealth\", " +
                "usted acepta los Términos y Condiciones del Servicio.",
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LabeledButton(
            title = "Comenzar a utilizar NutriHealth",
            onClick = onNext,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    OverviewPage(
        tmb = 0,
        recommendedKcal = 0,
        protein = 0,
        carbs = 0,
        fats = 0,
        timeToReach = 0,
        onNext = {},
        modifier = Modifier.fillMaxSize()
    )
}