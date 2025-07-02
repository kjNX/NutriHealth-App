package com.unmsm.nutrihealth_app.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.unmsm.nutrihealth_app.R
import com.unmsm.nutrihealth_app.ui.screen.shard.LabeledButton

data class OnboardingData(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
    val onClick: (() -> Unit)? = null
) {
    @Composable
    fun Page(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            if(onClick != null) LabeledButton("Comenzar", onClick)
        }
    }
}

@Composable
fun OnboardingScreen(onExit: () -> Unit, modifier: Modifier = Modifier) {
    val onboardingList = listOf(
        OnboardingData(
            title = "Bienvenido a NutriHealth",
            description = "Tu asistente personal para alcanzar tus objetivos de salud y fitness",
            image = R.drawable.logo_nutrihealth
        ),
        OnboardingData(
            title = "Seguimiento completo",
            description = "Registra tu alimentación, actividad física y progreso en un solo lugar",
            image = R.drawable.logo_nutrihealth
        ),
        OnboardingData(
            title = "Personalizado para ti",
            description = "Recibe recomendaciones adaptadas a tus objetivos y preferencias",
            image = R.drawable.logo_nutrihealth,
            onClick = onExit
        )
    )
    val pagerState = rememberPagerState { onboardingList.size }

    HorizontalPager(modifier = modifier, state = pagerState) { page ->
        onboardingList[page].Page(modifier = Modifier.fillMaxSize())
    }
}
