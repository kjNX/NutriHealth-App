package com.unmsm.nutrihealth_app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.screen.shard.IndexLabel
import com.unmsm.nutrihealth_app.ui.screen.shard.KeyIndicator
import com.unmsm.nutrihealth_app.ui.screen.shard.LabeledProgressBar
import com.unmsm.nutrihealth_app.ui.screen.shard.TitledCard
import com.unmsm.nutrihealth_app.ui.screen.shard.ValueCard
import com.unmsm.nutrihealth_app.util.icon.FoodBank
import com.unmsm.nutrihealth_app.util.icon.Target

@Composable
fun ProfileTag(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp).size(48.dp)
            )
            Column {
                Text(text = "Juan García")
                Text(text = "juan.garcia@ejemplo.com")
            }
        }
    }
}

@Composable
fun TargetWeight(modifier: Modifier = Modifier) {
    TitledCard(
        title = "Mi objetivo de peso",
        icon = Target,
        modifier = modifier
    ) {
        KeyIndicator(
            title = "Peso actual",
            value = "68 kg",
            icon = Icons.Default.DateRange
        )
        KeyIndicator(
            title = "Peso objetivo",
            value = "62 kg",
            icon = Icons.Default.Check
        )
        LabeledProgressBar(
            title = "Progreso",
            value = .75f
        )
    }
}

@Composable
fun NutritionalPlan(modifier: Modifier = Modifier) {
    TitledCard(title = "Plan alimenticio", icon = FoodBank) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Calorías diarias", style = MaterialTheme.typography.bodyLarge)
            Text("2150 kcal", style = MaterialTheme.typography.bodyLarge)
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ValueCard(
                title = "Proteínas",
                percentage = 30,
                amount = 161,
                bgColor = Color(0xFF9CCC65), // verde claro
                modifier = Modifier.weight(1f)
            )
            ValueCard(
                title = "Carbohidratos",
                percentage = 45,
                amount = 242,
                bgColor = Color(0xFFFFF176), // amarillo suave
                modifier = Modifier.weight(1f)
            )
            ValueCard(
                title = "Grasas",
                percentage = 25,
                amount = 60,
                bgColor = Color(0xFFE57373), // rojo rosado
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Recommendations(
    onFoodRecommendations: () -> Unit,
    onSuggestedExercises: () -> Unit,
    onReSetup: () -> Unit,
    modifier: Modifier = Modifier
) {
    TitledCard(
        title = "Recomendaciones",
        icon = Icons.Default.ThumbUp,
        modifier = modifier
    ) {
        IndexLabel(
            title = "Comidas recomendadas",
            subtitle = "Basado en tus objetivos",
            onClick = onFoodRecommendations
        )
        IndexLabel(
            title = "Ejercicios sugeridos",
            subtitle = "Para maximizar resultados",
            onClick = onSuggestedExercises
        )
        IndexLabel(
            title = "Actualizar perfil",
            subtitle = "Modificar tu perfil y metas actuales",
            onClick = onReSetup
        )
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileTag()
        TargetWeight()
        NutritionalPlan()
        Recommendations({}, {}, {})
    }
}

